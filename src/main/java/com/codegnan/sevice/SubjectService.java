package com.codegnan.sevice;

import com.codegnan.entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAll();

    Subject getById(Long id);

    Subject create(Subject subject);

    Subject update(Long id, Subject subject);

    void delete(Long id);
}
