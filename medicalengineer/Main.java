package medicalengineer;

public class Main {
	public static void main(String[] args) {
		
		InfusionPump p = new InfusionPump();
		p.setborrow();
		
		Redo redo = new Redo();
		redo.redoBorrowdays(p);
		redo.redoBorrowdays(p);
		redo.checkBorrowdays(p);
		
		Department depart = new Department();
		depart.inputDepartmentName();
		p.fourdigitNumber(); 
		
		Mapping m = new Mapping();
		m.borrowPut(depart, p);
		p.setreturn();
		depart.setDepartmentName(p);
		m.borrowPut(depart, p);
		
		Time t = new Time();
		t.timeTrance(p);
	}

}
