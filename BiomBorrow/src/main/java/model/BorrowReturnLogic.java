package model;
import java.time.LocalDateTime;

import dao.BorrowReturnDAO;

public class BorrowReturnLogic {
	public boolean BorrowExecute(LocalDateTime BorrowDate, int meNO, int department) {
		BorrowDate borrowdays = new BorrowDate(BorrowDate);
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		Place place = new Place(department);
		BorrowReturnDAO dao = new BorrowReturnDAO();
		boolean resultBo = dao.BorrowCreate(borrowdays, medicalEquipment, place);
		return resultBo;
	}
	public void ReturnExecute(int meNO, LocalDateTime ReturnDate) {
		ReturnDate returndays = new ReturnDate(ReturnDate);
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		BorrowReturnDAO dao = new BorrowReturnDAO();
		dao.ReturnCreate(medicalEquipment,returndays);
	}
	public MedicalEquipment getMedicalEquipmentByMeNo(int meNO) {
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		BorrowReturnDAO dao = new BorrowReturnDAO();
		//2023/09/06
		return dao.findMedicalEquipmentByMeNo(medicalEquipment);
		//MedicalEquipment equipment = dao.findMedicalEquipmentByMeNo(medicalEquipment);
		//if(equipment.getModelNumber() == null) {
			//equipment.setModelNumber("不明");
		//}
		//if(equipment.getSerialNumber() == null) {
			//equipment.setSerialNumber("不明");
		//} 
		//if(equipment.getManufacturer() == null) {
			//equipment.setManufacturer("不明");
		//}
		//if(equipment.getIntroducedDate() == null) {
			//equipment.setIntroducedDate("不明");
		//}
	}
}