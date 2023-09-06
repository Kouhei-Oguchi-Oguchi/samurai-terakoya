package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ReturnDate implements Serializable {
	private static LocalDateTime returndays;
	public ReturnDate() {}

	public ReturnDate(LocalDateTime returndays) {
		this.returndays = returndays;
	}
	public LocalDateTime getReturndays() {
		return returndays;
	}
	public void setReturndays(LocalDateTime returndays) {
		this.returndays = returndays;
	}
}
