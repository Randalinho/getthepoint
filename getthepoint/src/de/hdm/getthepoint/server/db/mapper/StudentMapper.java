package de.hdm.getthepoint.server.db.mapper;

import java.util.List;

import de.hdm.getthepoint.server.db.model.Student;
import de.hdm.getthepoint.shared.bo.StudentBo;

public class StudentMapper implements DbMapperInterface<StudentBo, Student> {

	@Override
	public List<StudentBo> getModelsAsList(List<Student> dbmodels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBo getModel(Student dbmodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getDbModel(StudentBo model) {
		// TODO Auto-generated method stub
		return null;
	}

}
