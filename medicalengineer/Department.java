package medicalengineer;
import java.util.Scanner;
public class Department {
	private String departmentName;

	public void inputDepartmentName() {
		System.out.println("貸出先を選択して下さい。3階東:1, 3階西:2, 介護医療院:3, 2階西:4, 南4階:5, 南3階:6, 南2階:7, 南１階:8, 南新館:9, その他:10, ME:11");
		String department = new Scanner(System.in).nextLine();
		switch(department) {
		case "1":
			department = "3階東";
			break;
		case "2":
			department = "3階西";
			break;
		case "3":
			department = "介護医療院";
			break;
		case "4":
			department = "2階西";
			break;
		case "5":
			department = "南4階";
			break;
		case "6":
			department = "南3階";
			break;
		case "7":
			department = "南2階";
			break;
		case "8":
			department = "南1階";
			break;
		case "9":
			department = "南新館";
			break;
		case "10":
			department = "その他";
			break;
		default:
			System.out.println("再入力して下さい");
			inputDepartmentName();
		}
		this.departmentName = department;
	}
	public String getDepartmentName() {
		return this.departmentName;
	}
	public void setDepartmentName(InfusionPump p) {
		//返却日が入力されたらdepartmetNameのフィールドをmedicalengineerにする
		if(p.getReturndays() == p.getReturndays()) {
			this.departmentName = "medicalengineer";
		}
	}
}
