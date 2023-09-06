package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class MedicalEquipment implements Serializable {
	private int medicalEquipmen = 0;
	private String modelNumber = "";
	private String serialNumber= ""
;	private String manufacturer= "";
	private LocalDateTime introducedDate = LocalDateTime.now();
	private LocalDateTime borrowDate = LocalDateTime.now();
	private LocalDateTime returnDate = LocalDateTime.now();                                  
	private String place = "";

	public MedicalEquipment() { }
	public MedicalEquipment(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}
	public int getMedicalEquipmen() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmen(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}

	public  MedicalEquipment(int medicalEquipmen, String modelNumber, String serialNumber, String manufacturer, LocalDateTime introducedDate,LocalDateTime borrowDate,LocalDateTime returnDate, String place) {
		this.medicalEquipmen = medicalEquipmen;
		this.modelNumber = modelNumber;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.introducedDate = introducedDate;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.place = place;

	}
	public int getMedicalEquipmenNO() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmenNO(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public LocalDateTime getIntroducedDate() {
		return introducedDate;
	}
	public void setIntroducedDate(LocalDateTime introducedDate) {
		this.introducedDate = introducedDate;
	}
	public LocalDateTime getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

}
