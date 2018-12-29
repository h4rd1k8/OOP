package intranet.impl;

import java.io.Serializable;

public class Date implements Serializable{
	private static final long serialVersionUID = 1L;
	private int Year;
	private int Month;
	private int Day;
	
	public Date(int day, int month, int year) {
		Year = year;
		Month = month;
		Day = day;
	}
	
	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Day;
		result = prime * result + Month;
		result = prime * result + Year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (Day != other.Day)
			return false;
		if (Month != other.Month)
			return false;
		if (Year != other.Year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Date [Day=" + Day + ", Month=" + Month + ", Year=" + Year + "]";
	}
	
	
}
