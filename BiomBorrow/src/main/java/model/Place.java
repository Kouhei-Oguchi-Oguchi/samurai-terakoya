package model;
import java.io.Serializable;

public class Place implements Serializable {
	private static int place;
	private static String placeName;

	public Place() {}
	public Place(int place) {
		this.place = place;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public Place(String placeName) {
		this.placeName =  placeName;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String toString() {
	    return placeName;
	}
}