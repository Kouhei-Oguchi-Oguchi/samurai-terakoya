package test;
import java.time.LocalDateTime;

import model.BorrowReturnLogic;
import model.MedicalEquipment;

public class BorrowRerutnLogicTset {
	public static void main(String[] args) {
		//testBorrowExecuteOK();
		//testReturnExecuteOK();
		testMedicalEquipmentByMeNo();
	}
	public static void testBorrowExecuteOK() {
		LocalDateTime BorrowDate = LocalDateTime.of(1990, 12, 15, 0, 0);
		int meNO = 1007;
		int department = 1;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		boolean resultBo = bo.BorrowExecute(BorrowDate, meNO, department);
		if(resultBo == true) {
			System.out.println("OK");
		}else {
			System.out.println("NG");
		}
	}
	public static void testReturnExecuteOK() {
		LocalDateTime ReturnDate = LocalDateTime.of(1990, 12, 20, 0, 0);
		int meNO = 1007;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		bo.ReturnExecute(meNO,ReturnDate);
	}
	public static void testMedicalEquipmentByMeNo() {
		int meNO = 1004;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipment equipmentValue = bo.getMedicalEquipmentByMeNo(meNO);
		if (equipmentValue != null) {
		System.out.println("Equipment ID: " + equipmentValue.getMedicalEquipmen());
		System.out.println("Model Number: " + equipmentValue.getModelNumber());
		System.out.println("Serial Number: " + equipmentValue.getSerialNumber());
		System.out.println("Manufacturer: " + equipmentValue.getManufacturer());
		System.out.println("Introduced Date: " + equipmentValue.getIntroducedDate());
		System.out.println("Borrow Date: " + equipmentValue.getBorrowDate());
		System.out.println("Return Date: " + equipmentValue.getReturnDate());
		System.out.println("Place: " + equipmentValue.getPlace());
		}else {
			System.out.println("テーブルに結果がありませんでした");
		}
	}

}