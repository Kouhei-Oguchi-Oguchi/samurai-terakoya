package medicalengineer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Time {
	public void timeTrance(InfusionPump p) { 
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate dateB = LocalDate.parse(p.getBorrowdays(),fmt);
		//貸出日がLocalDateに変換
		LocalDate dateR = LocalDate.parse(p.getReturndays(),fmt);
		Period dateDifference = Period.between(dateB, dateR);
		dateDifference.getYears();
		dateDifference.getMonths();
		dateDifference.getDays();
		System.out.println("稼働日数は" + dateDifference.getYears()  + "年" + dateDifference.getMonths() + "ヵ月" + dateDifference.getDays() + "日" + "でした" );

		//返却日がLocalDateに変換
		//System.out.println(dateB);
		//System.out.println(dateR);
		//int dateS = dateB.compareTo(dateR);
		//System.out.println(dateS);
		//if (dateS < 0) {
		//System.out.println("返却済です");
		//}else if(dateS > 0) {
		//System.out.println("返却されていません");
		//-1:返却方があと貸出日より
		//1 : 貸出日の方が後
		//0  貸出び＝返却日
	}
}
