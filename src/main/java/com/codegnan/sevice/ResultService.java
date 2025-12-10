package com.codegnan.sevice;

import com.codegnan.entity.Result;

import java.util.List;

public interface ResultService {

    List<Result> getAll();

    Result getById(Long id);

    Result create(Long studentId, Long subjectId, Result result);

    Result update(Long id, Integer marks);

    void delete(Long id);
}
