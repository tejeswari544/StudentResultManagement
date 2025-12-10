package com.codegnan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegnan.entity.Student;

public interface Studentrepo extends JpaRepository<Student,Long> {

}
