package test;
import java.time.LocalDateTime;

import dao.BorrowReturnDAO;
import model.BorrowDate;
import model.BorrowReturnID;
import model.MedicalEquipment;
import model.Place;

public class DAOtest {
	public static void main (String[] args) {
		//testBorrowCreateSQLOK();
		EquipmentInformation();
	}
	public static void testBorrowCreateSQLOK() {
		LocalDateTime BorrowTest = LocalDateTime.of(2023, 1, 1, 0, 0);
		BorrowDate borrowdate = new BorrowDate(BorrowTest);
		MedicalEquipment medicalEquipment = new MedicalEquipment(1000);
		Place place = new Place(1);
		BorrowReturnDAO borrowreturnDAO = new BorrowReturnDAO();
		BorrowReturnID borrowreturnID = new BorrowReturnID();
		boolean result = borrowreturnDAO.BorrowCreate(borrowdate, medicalEquipment, place);
		if(result == true) {
			System.out.println("成功しました");
		}else{
			System.out.println("失敗しました");
		}
	}
	public static void testCreateSQLNG() {
		LocalDateTime BorrowTest = LocalDateTime.of(2023, 1, 1, 0, 0);
		BorrowDate borrowreturn = new BorrowDate(BorrowTest);
		MedicalEquipment medicalEquipment = new MedicalEquipment(1000);
		Place place = new Place(1);
		BorrowReturnDAO borrowreturnDAO = new BorrowReturnDAO();
		boolean result = borrowreturnDAO.BorrowCreate(borrowreturn, medicalEquipment, place);
		if(result == true) {
			System.out.println("成功しました");
		}else{
			System.out.println("失敗しました");
		}

	}
	public static void EquipmentInformation() {
		MedicalEquipment medicalEquipment = new MedicalEquipment(1003);
		BorrowReturnDAO borrowreturnDAO = new BorrowReturnDAO();
		MedicalEquipment fetchedEquipment = borrowreturnDAO.findMedicalEquipmentByMeNo(medicalEquipment);
		if(fetchedEquipment != null) {
	        System.out.println("Equipment ID: " + fetchedEquipment.getMedicalEquipmen());
	        System.out.println("Model Number: " + fetchedEquipment.getModelNumber());
	        System.out.println("Serial Number: " + fetchedEquipment.getSerialNumber());
	        System.out.println("Manufacturer: " + fetchedEquipment.getManufacturer());
	        System.out.println("Introduced Date: " + fetchedEquipment.getIntroducedDate());
	        System.out.println("Borrow Date: " + fetchedEquipment.getBorrowDate());
	        System.out.println("Return Date: " + fetchedEquipment.getReturnDate());
	        System.out.println("Place: " + fetchedEquipment.getPlace());
		}else {
			 System.out.println("習得できませんでした");
		}
		
	}
}


