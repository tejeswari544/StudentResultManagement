package com.codegnan.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Subject;
import com.codegnan.exception.ResourceNotFoundException;
import com.codegnan.repository.Subjectrepo;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	private final Subjectrepo subjectrepo;
	

	public SubjectServiceImpl(Subjectrepo subjectrepo) {
		super();
		this.subjectrepo = subjectrepo;
	}

	@Override
	public List<Subject> getAll() {
		// TODO Auto-generated method stub
		return subjectrepo.findAll();
	}

	@Override
	public Subject getById(Long id) {
		// TODO Auto-generated method stub
		return subjectrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("subjetc","id",id));
	}

	@Override
	public Subject create(Subject subject) {
		// TODO Auto-generated method stub
		subject.setId(null);
        return subjectrepo.save(subject);
	}

	@Override
	public Subject update(Long id, Subject subject) {
		// TODO Auto-generated method stub
		Subject exisiting=getById(id);
		exisiting.setName(subject.getName());
		exisiting.setCode(subject.getCode());
		return subjectrepo.save(exisiting);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		  Subject existing = getById(id);
	        subjectrepo.delete(existing);
		
	}

}
