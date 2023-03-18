package medicalengineer;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

	public void borrowPut(Department d,InfusionPump p) {
		Map<String, Integer> prefet = new HashMap<String, Integer>();
		prefet.put(d.getDepartmentName(), p.getMenumber());
		//1.返却日が入力されたら、このMap解除されなければならない
		int mdName = prefet.get(d.getDepartmentName());
		if(p.getReturndays() == null) {
			System.out.println("貸出処理は完了しました");	 
			System.out.println(mdName + "は" +  d.getDepartmentName() + "で稼働中"); 
		}
		else if(p.getReturndays() == p.getReturndays()) {
			prefet.remove(d.getDepartmentName());
			prefet.put("medicalengineer", p.getMenumber());
			int mdName2 = prefet.get("medicalengineer");
			System.out.println(mdName2 + "の" +  d.getDepartmentName() + "返却されました"); 
		} 
		//2.時間による制御が必要
		//putで追加するには、メソッドを作成しないと追加する事ができない！！
		//putの( )の中にインスタンスのフィールド名を入力できない・
	}
}

