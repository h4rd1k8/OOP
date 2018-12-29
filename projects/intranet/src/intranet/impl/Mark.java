package intranet.impl;

import java.util.HashMap;
import java.util.Map;

public class Mark {
	
	private Map<String, Double> Marks;
	
	public Mark(String key, Double value) {
		Marks = new HashMap<>();
		Marks.put(key, value);
	}
	
	public void addMark(String key, Double value) {
		Marks.put(key, value);
	}
	
	public void changeMark(String key, Double value) {
		Marks.put(key, value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Marks == null) ? 0 : Marks.hashCode());
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
		Mark other = (Mark) obj;
		if (Marks == null) {
			if (other.Marks != null)
				return false;
		} else if (!Marks.equals(other.Marks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mark [Marks=" + Marks + "]";
	}
	
	

}
