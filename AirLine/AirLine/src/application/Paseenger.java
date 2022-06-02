package application;

public class Paseenger implements Comparable<Paseenger> {

	private int flightNum;
	private int tacket;
	private String fullName;
	private double passportNumber;
	private String nationalty;
	private String dateOfParth;

	public Paseenger(int flightNum, int tacket, String fullName, double passportNumber, String nationalty,
			String dateOfParth) {
		super();
		if (flightNum != 0 && tacket != 0 && fullName.length() > 0 && passportNumber != 0 && nationalty.length() > 0
				&& dateOfParth.length() > 0) {
			this.setFlightNum(flightNum);
			this.setTacket(tacket);
			this.setFullName(fullName);
			this.setPassportNumber(passportNumber);
			this.setNationalty(nationalty);
			this.setDateOfParth(dateOfParth);
		}
	}

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public int getTacket() {
		return tacket;
	}

	public void setTacket(int tacket) {
		this.tacket = tacket;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(double passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getNationalty() {
		return nationalty;
	}

	public void setNationalty(String nationalty) {
		this.nationalty = nationalty;
	}

	public String getDateOfParth() {
		return dateOfParth;
	}

	public void setDateOfParth(String dateOfParth) {
		this.dateOfParth = dateOfParth;
	}

	public void serchPaseenger(int passportNumber) {

		System.out.println("paseenger is  :");
	}

	@Override
	public int compareTo(Paseenger o) {
		if (this.fullName.compareToIgnoreCase(o.fullName) == 0) {
			return 0;
		} else if (this.fullName.compareToIgnoreCase(o.fullName) < 0) {
			return -1;
		} else
			return 1;
	}

	@Override
	public String toString() {
		return "Paseenger [flightNum=" + flightNum + ", tacket=" + tacket + ", fullName=" + fullName
				+ ", passportNumber=" + passportNumber + ", nationalty=" + nationalty + ", dateOfParth=" + dateOfParth
				+ "]";
	}

}
