package application;

public class Flights implements Comparable<Flights> {

	private int flightNum;
	private String ariLine;
	private String sorce;
	private String distantion;
	private int capacty;
	public LinkedList<Paseenger> LPaseenger = new LinkedList<>();

	public Flights(int flightNum, String ariLine, String sorce, String distantion, int capacty) {
		super();
		if (flightNum != 0 && ariLine.length() > 0 && sorce.length() > 0 && distantion.length() > 0 && capacty != 0) {
			this.setFlightNum(flightNum);
			this.setAriLine(ariLine);
			this.setSorce(sorce);
			this.setDistantion(distantion);
			this.setCapacty(capacty);
		}
	}

	public Flights() {
		super();
	}

	public void showPaseengerList() {
		LPaseenger.show();
	}

	public LinkedList<Paseenger> getLPaseenger() {

		return LPaseenger;
	}

	public void setLPaseenger(LinkedList<Paseenger> lPaseenger) {
		LPaseenger = lPaseenger;
	}

	public void isertPassenger(Paseenger pass) {
		LPaseenger.insertion(pass);
	}

	public void delePassenger(Paseenger pass) {
		LPaseenger.delete(pass);
	}

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public String getAriLine() {
		return ariLine;
	}

	public void setAriLine(String ariLine) {
		this.ariLine = ariLine;
	}

	public String getSorce() {
		return sorce;
	}

	public void setSorce(String sorce) {
		this.sorce = sorce;
	}

	public String getDistantion() {
		return distantion;
	}

	public void setDistantion(String distantion) {
		this.distantion = distantion;
	}

	public int getCapacty() {
		return capacty;
	}

	public void setCapacty(int capacty) {
		this.capacty = capacty;
	}

	@Override
	public int compareTo(Flights o) {
		if (this.getFlightNum() > o.getFlightNum()) {
			return 1;
		} else if (this.getFlightNum() == o.getFlightNum()) {
			return 0;
		}
		return -1;
	}

	@Override
	public String toString() {

		String s = " " + "Flights [flightNum=" + flightNum + ", ariLine=" + ariLine + ", sorce=" + sorce
				+ ", distantion=" + distantion + ", capacty=" + capacty + "]\n" + LPaseenger.display();

		return s;
	}

}
