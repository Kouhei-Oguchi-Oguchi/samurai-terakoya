package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import model.BorrowDate;
import model.BorrowReturnID;
import model.MedicalEquipment;
import model.Place;
import model.ReturnDate;

public class BorrowReturnDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/borrow_return";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean BorrowCreate(BorrowDate borrowdays, MedicalEquipment medicalquiment, Place place) {
		try {
			Class.forName("org.h2.Driver");
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCプログラムは読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO  BORROW_RETURN (BORROW_DAYS, MENO, PLACE_NO) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			LocalDateTime Borrowdate = borrowdays.getBorrowdays();
			Timestamp borrowTimestamp = borrowdays != null ? Timestamp.valueOf(Borrowdate) : null;
			//Timestamp borrowTimestamp = Timestamp.valueOf(borrwdate);
			pStmt.setTimestamp(1,borrowTimestamp);
			pStmt.setInt(2, medicalquiment.getMedicalEquipmen());
			pStmt.setInt(3, place.getPlace());
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public void ReturnCreate(MedicalEquipment medicalEquipment,  ReturnDate returndays) {
		int borrowReturnIDValue;
		try {
			Class.forName("org.h2.Driver");
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCプログラムは読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT BORROW_RETURNID FROM BORROW_RETURN WHERE MENO = ? AND RETURN_DAYS IS NULL ORDER BY BORROW_DAYS LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			LocalDateTime returndate = returndays.getReturndays();
			Timestamp borrowreturnTimestamp = Timestamp.valueOf(returndate);
			pStmt.setInt(1, medicalEquipment.getMedicalEquipmen());
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				borrowReturnIDValue = rs.getInt("BORROW_RETURNID");
				BorrowReturnID borrowreturnID = new BorrowReturnID(borrowReturnIDValue);
				borrowreturnID.setBorrowReturnID(borrowReturnIDValue);
				String sql2 = "UPDATE BORROW_RETURN SET RETURN_DAYS = ? WHERE BORROW_RETURNID = ?";
				try(PreparedStatement pstmt2 = conn.prepareStatement(sql2)){
					pstmt2.setTimestamp(1,borrowreturnTimestamp);
					pstmt2.setInt(2, borrowReturnIDValue);
					int updatedRows = pstmt2.executeUpdate();
					if(updatedRows > 0) {
						System.out.println("Successfully updated RETURN_DAYS for BORROW_RETURNID: " + borrowReturnIDValue);
					} else {
						System.out.println("No rows to update. Check if BORROW_RETURNID is correct.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("No rows to update. Check if MENO is correct and RETURN_DAYS is NULL."); 	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}public MedicalEquipment findMedicalEquipmentByMeNo(MedicalEquipment medicalEquipment) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT IP.MENO, MODEL_NUMBER, SERIAL_NUMBER, MANUFACTURER, INTRODUCED_DATE, BR.BORROW_DAYS, BR.RETURN_DAYS, P.PLACE_P " +
					"FROM INFUSIONPUMP AS IP " +
					"JOIN BORROW_RETURN AS BR ON IP.MENO = BR.MENO " +
					"JOIN PLACE AS P ON BR.PLACE_NO = P.PLACE_NO " +
					"WHERE IP.MENO = ? AND BR.BORROW_RETURNID = (SELECT MAX(BORROW_RETURNID) FROM BORROW_RETURN WHERE MENO = ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,medicalEquipment.getMedicalEquipmen());
			pStmt.setInt(2,medicalEquipment.getMedicalEquipmen());
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int medicalEquipmenValue = rs.getInt("MENO");
				String modelNumber = rs.getString("MODEL_NUMBER");
				String serialNumber = rs.getString("SERIAL_NUMBER");
				String manufacturer = rs.getString("MANUFACTURER");
				Timestamp introducedDateValue = rs.getTimestamp ("INTRODUCED_DATE");
				LocalDateTime introducedDate = introducedDateValue.toLocalDateTime();
				Timestamp borrowdaysValue = rs.getTimestamp("BORROW_DAYS");
				LocalDateTime borrowDate = borrowdaysValue.toLocalDateTime();
				Timestamp returndaysValue = rs.getTimestamp("RETURN_DAYS");
				String place = rs.getString("PLACE_P");
				LocalDateTime returnDate = null;
				if(returndaysValue != null) {
					returnDate = returndaysValue.toLocalDateTime();
					place = "ME";
				}
				return new MedicalEquipment(medicalEquipmenValue, modelNumber, serialNumber, manufacturer, introducedDate, borrowDate, returnDate, place);
				}
	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}
	return null;
}
}
