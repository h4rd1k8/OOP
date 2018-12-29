package intranet.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer CourseId;
    private String Title;
    private Integer RequiredYear;
    private String RequiredSpecialization;
    private Integer SectionNumber;
    private User Teacher;
    private List<Employee> Faculty;
    private List<CourseFile> CourseFiles;
    private List<User> ListOfStudents;
    private Map<User, Mark> Marks;
    
	public Course(Integer courseId, String title, Integer requiredYear, String requiredSpecialization,
			Integer sectionNumber, User teacher, List<Employee> faculty) {
		CourseId = courseId;
		Title = title;
		RequiredYear = requiredYear;
		RequiredSpecialization = requiredSpecialization;
		SectionNumber = sectionNumber;
		Teacher = teacher;
		Faculty = faculty;
	}
	
	public Integer getCourseId() {
		return CourseId;
	}
	
	public void setCourseId(Integer courseId) {
		CourseId = courseId;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		Title = title;
	}
	
	public Integer getRequiredYear() {
		return RequiredYear;
	}
	
	public void setRequiredYear(Integer requiredYear) {
		RequiredYear = requiredYear;
	}
	
	public String getRequiredSpecialization() {
		return RequiredSpecialization;
	}
	
	public void setRequiredSpecialization(String requiredSpecialization) {
		RequiredSpecialization = requiredSpecialization;
	}
	
	public Integer getSectionNumber() {
		return SectionNumber;
	}
	
	public void setSectionNumber(Integer sectionNumber) {
		SectionNumber = sectionNumber;
	}
	
	public User getTeacher() {
		return Teacher;
	}
	
	public void setTeacher(User teacher) {
		Teacher = teacher;
	}
	
	public List<Employee> getFaculty() {
		return Faculty;
	}
	
	public void setFaculty(List<Employee> faculty) {
		Faculty = faculty;
	}
	
	public List<User> getListOfStudents() {
		return ListOfStudents;
	}

	public void setListOfStudents(List<User> listOfStudents) {
		ListOfStudents = listOfStudents;
	}

	public Map<User, Mark> getMarks() {
		return Marks;
	}

	public void setMarks(Map<User, Mark> marks) {
		Marks = marks;
	}
	
	public Mark getMarksByStudent(User student) {
		return Marks.get(student);
	}
	
	public List<CourseFile> getCourseFiles() {
		return CourseFiles;
	}
	
	public void registerStudent(User student) {
		ListOfStudents.add(student);
	}
	
	public void putMark(User student, String key, Double value) {
		Mark m = Marks.get(student);
		if (m == null) {
			Marks.put(student, new Mark(key, value));
		} else {
			m.addMark(key, value);
		}
	}
	
	public void changeMark(User student, String key, Double value) {
		Mark m = Marks.get(student);
		if (m != null) {
			m.changeMark(key, value);
		}
		//do nothing
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CourseId == null) ? 0 : CourseId.hashCode());
		result = prime * result + ((Faculty == null) ? 0 : Faculty.hashCode());
		result = prime * result + ((RequiredSpecialization == null) ? 0 : RequiredSpecialization.hashCode());
		result = prime * result + ((RequiredYear == null) ? 0 : RequiredYear.hashCode());
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
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
		Course other = (Course) obj;
		if (CourseId == null) {
			if (other.CourseId != null)
				return false;
		} else if (!CourseId.equals(other.CourseId))
			return false;
		if (Faculty == null) {
			if (other.Faculty != null)
				return false;
		} else if (!Faculty.equals(other.Faculty))
			return false;
		if (RequiredSpecialization == null) {
			if (other.RequiredSpecialization != null)
				return false;
		} else if (!RequiredSpecialization.equals(other.RequiredSpecialization))
			return false;
		if (RequiredYear == null) {
			if (other.RequiredYear != null)
				return false;
		} else if (!RequiredYear.equals(other.RequiredYear))
			return false;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", Title=" + Title + ", RequiredYear=" + RequiredYear
				+ ", RequiredSpecialization=" + RequiredSpecialization + ", SectionNumber=" + SectionNumber
				+ ", Teacher=" + Teacher + ", Faculty=" + Faculty + ", CourseFile=" + CourseFiles + ", Marks=" + Marks
				+ "]";
	}
    
}
