package com.codegnan.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Result;
import com.codegnan.entity.Student;
import com.codegnan.entity.Subject;
import com.codegnan.exception.ResourceNotFoundException;
import com.codegnan.repository.Resultrepo;
import com.codegnan.repository.Studentrepo;
import com.codegnan.repository.Subjectrepo;
@Service
public class ResultServiceImpl implements ResultService{
	
	private final Resultrepo resultrepo;
	private final Studentrepo studentrepo;
	private final Subjectrepo subjectrepo;
	
	

	public ResultServiceImpl(Resultrepo resultrepo, Studentrepo studentrepo, Subjectrepo subjectrepo) {
		super();
		this.resultrepo = resultrepo;
		this.studentrepo = studentrepo;
		this.subjectrepo = subjectrepo;
	}

	@Override
	public List<Result> getAll() {
		// TODO Auto-generated method stub
		return resultrepo.findAll();
	}

	@Override
	public Result getById(Long id) {
		// TODO Auto-generated method stub
		return resultrepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Result","id",id));
	}

	@Override
	public Result create(Long studentId, Long subjectId, Result result) {
		Student student=studentrepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student","id",studentId));
		Subject subject=subjectrepo.findById(subjectId).orElseThrow(()->new ResourceNotFoundException("Subject","id",subjectId));
		// TODO Auto-generated method stub
		 result.setId(null);
	        result.setStudent(student);
	        result.setSubject(subject);

	        if (result.getMarks() != null) {
	            int m = result.getMarks();
	            if (m >= 90) result.setGrade("A");
	            else if (m >= 80) result.setGrade("B");
	            else if (m >= 70) result.setGrade("C");
	            else if (m >= 60) result.setGrade("D");
	            else result.setGrade("F");
	        }

	        return resultrepo.save(result);
	    }

	@Override
	public Result update(Long id, Integer marks) {
		Result existing = getById(id);
        existing.setMarks(marks);

        if (marks != null) {
            int m = marks;
            if (m >= 90) existing.setGrade("A");
            else if (m >= 80) existing.setGrade("B");
            else if (m >= 70) existing.setGrade("C");
            else if (m >= 60) existing.setGrade("D");
            else existing.setGrade("F");
        }

        return resultrepo.save(existing);
    }

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Result exisiting=getById(id);
		resultrepo.delete(exisiting);
		
	}

}
