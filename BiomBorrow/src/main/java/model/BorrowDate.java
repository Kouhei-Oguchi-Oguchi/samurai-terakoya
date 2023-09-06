package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BorrowDate implements Serializable{
	private static LocalDateTime borrowdays;
	public BorrowDate() {}
	public BorrowDate(LocalDateTime borrowdays) {
		this.borrowdays = borrowdays;	
	}
	public LocalDateTime getBorrowdays() {
		return borrowdays;
	}
	public void setBorrowdays(LocalDateTime borrow_days) {
		this.borrowdays = borrow_days;
	}
}

