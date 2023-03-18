package medicalengineer;
import java.util.Scanner;

public class InfusionPump {
	private int meNo;
	String trader = "JMS";
	private String borrowDays;
	private String returnDays;

	public void setborrow() {
		System.out.println("貸出日を入力してください（例）2022／12／12");
		String borrow = new Scanner(System.in).nextLine();
		this.borrowDays = borrow;	
	}
	public String getBorrowdays() {
		return this.borrowDays;
	}
	public void fourdigitNumber() {
		System.out.println("4桁の番号を入力してください");
		int meno = new Scanner(System.in).nextInt();
		this.meNo = meno;
	}
	public int getMenumber() {
		return this.meNo;
	}
	public void setreturn() {
		System.out.println("返却日を入力してください（例）2022／12／12");
		String returnDay  = new Scanner(System.in).nextLine();
		this.returnDays = returnDay;
	}
	public String getReturndays() {
		return this.returnDays;
	}

	//String ward = new java.util.Scanner (System .in ).nextLine();		
	//DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	//LocalDate borrwTime = LocalDate.parse(borrw,fmt);
	//System.out.println("返却日を入力してください（例）2022／12／12");
	//String returnReturn = new java.util.Scanner (System .in ).nextLine();
	// returnTime = LocalDate.parse(returnReturn,fmt);
	//Period p1 = Period.between(borrowTime, returnTime);
	//if(returnTime.isBefore(borrowTime)) {
	//System.out.println("貸出中");
	//}
	//else if(returnTime.isAfter(borrowTime)) {
	//System.out.println("返却済");

	//String stringBorrwtime = borrowTime.format(fmt);
	//String stringReturntime = returnTime.format(fmt);






}

