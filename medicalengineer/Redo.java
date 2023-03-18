package medicalengineer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Redo {

	public void redoBorrowdays(InfusionPump p) {
		boolean f = p.getBorrowdays().matches("[0-9][0-9][0-9][0-9]/[0-9][0-9]/[0-9][0-9]");
		if (f == false) {
			System.out.println("入力が間違っています。再度貸出日を入力して下さい（例)1970/12/12");
			p.setborrow();
		}
	}
	public void checkBorrowdays(InfusionPump p) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate dateB = LocalDate.parse(p.getBorrowdays(),fmt);
		dateB.getYear();
		dateB.getMonth();
		dateB.getDayOfMonth();
		LocalDate A = LocalDate.now();
		A.getYear();
		A.getMonth();
		A.getDayOfMonth();

		if(dateB.getYear() != A.getYear() || dateB.getMonth() != A.getMonth() || dateB.getDayOfMonth() != A.getDayOfMonth() ) {
			System.out.println("貸出日の入力が過去,未来になっています実行しますか？.0:再度入力、1:実行");
			int input = new java.util.Scanner(System.in).nextInt();
			if (input == 0) {
				p.setborrow();
				redoBorrowdays(p);
			}else if(input >= 2) {
				p.setborrow();
				redoBorrowdays(p);
			}else if(input == 1) {
			}
		}
	}
	// public void chekDepartmentName(Department d) {
	// ArrayList <String> departmentMache = new ArrayList<String>();
	//departmentMache.add(d.getDepartmentName());
	//Iterator <String> it = departmentMache.iterator();
	// while (departmentMache.hasNext()) {

	//}
	//boolean l = d.getDepartmentName().matches("[3階東]");
	//|| 使用不可
	//boolean l2 = d.getDepartmentName().matches("[3階西]");
	//boolean l3 = d.getDepartmentName().matches("[介護医療院]");
	//boolean l4 = d.getDepartmentName().matches("[2階西]");
	//boolean l5 = d.getDepartmentName().matches("[南4階]");
	//boolean l6 = d.getDepartmentName().matches("[南3階]");
	//boolean l7 = d.getDepartmentName().matches("[南2階]");
	//boolean l8 = d.getDepartmentName().matches("[南1階]");
	//boolean l9 = d.getDepartmentName().matches("[南新階]");
	//boolean l10 = d.getDepartmentName().matches("[その他]");
	//boolean l11 = d.getDepartmentName().matches("[ME]");
	//if (l == false || l2 == false || l3 == false || l4 == false || l5 == false || l6 == false || l7 == false || l8 == false || l9 == false || l10 == false || l11 == false);
	//System.out.println("貸出先が正しくありません。再度入力して下さい");
	//d.departmentName();
	//chekDepartmentName(d);
	// }
}
