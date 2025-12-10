package com.codegnan.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Student;
import com.codegnan.exception.ResourceNotFoundException;
import com.codegnan.repository.Studentrepo;

@Service
public class StudenServiceImpl implements StudentService {
	
	private final Studentrepo studentrepo;
	
	

	public StudenServiceImpl(Studentrepo studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public Student getById(Long id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Student","id",id));
	}

	@Override
	public Student create(Student student) {
		student.setId(null);
		return studentrepo.save(student);
	}

	@Override
	public Student update(Long id, Student student) {
		Student exisiting=getById(id);
		exisiting.setName(student.getName());
		exisiting.setRollNo(student.getRollNo());
		exisiting.setEmail(student.getEmail());
		return studentrepo.save(exisiting);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		Student exisiting=getById(id);
		studentrepo.delete(exisiting);
		
	}

}
