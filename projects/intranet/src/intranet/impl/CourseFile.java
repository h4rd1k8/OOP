package intranet.impl;

import java.io.File;
import java.io.Serializable;

public class CourseFile implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer Id;
    private String Type;
    private String FileName;
    private File CFile;
    
	public CourseFile(Integer id, String type, String fileName, File cFile) {
		Id = id;
		Type = type;
		FileName = fileName;
		CFile = cFile;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	public String getFileName() {
		return Type;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public File getCFile() {
		return CFile;
	}

	public void setCFile(File cFile) {
		CFile = cFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FileName == null) ? 0 : FileName.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
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
		CourseFile other = (CourseFile) obj;
		if (FileName == null) {
			if (other.FileName != null)
				return false;
		} else if (!FileName.equals(other.FileName))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseFile [Id=" + Id + ", Type=" + Type + ", FileName=" + FileName + "]";
	}
	
}
