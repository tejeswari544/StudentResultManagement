package com.codegnan.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Student;

@Service
public interface StudentService {
	List<Student> getAll();
	Student getById(Long id);
	Student create(Student student);
	Student update(Long id ,Student student);
	void delete(Long id);

}
