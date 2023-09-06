package model;
import java.io.Serializable;


public class BorrowReturnID implements Serializable {
	private int borrowreturnID;
	public BorrowReturnID() {}
	public BorrowReturnID(int borrowreturnID) {
		this.borrowreturnID = borrowreturnID;
	}
	public void setBorrowReturnID(int borrowreturnID) {
		this.borrowreturnID = borrowreturnID;
	}
	public int getBorrowReturnID() {
		return borrowreturnID;
	}
}
