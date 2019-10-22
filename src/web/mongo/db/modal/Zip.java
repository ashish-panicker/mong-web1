package web.mongo.db.modal;

import org.bson.types.ObjectId;

public class Zip {

	private ObjectId id;
	private String city;
	private int pop;
	private String state;

	public Zip() {

	}

	public Zip( String city, int pop, String state) {
		super();
		this.city = city;
		this.pop = pop;
		this.state = state;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPop() {
		return pop;
	}

	public void setPop(int pop) {
		this.pop = pop;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
