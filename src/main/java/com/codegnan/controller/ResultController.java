package com.codegnan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.entity.Result;
import com.codegnan.sevice.ResultService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    @Operation(summary = "Get all results")
    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Get result by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Create a result for a student & subject")
    @PostMapping
    public ResponseEntity<Result> createResult(
            @RequestParam Long studentId,
            @RequestParam Long subjectId,
            @Valid @RequestBody Result result
    ) {
        Result saved = service.create(studentId, subjectId, result);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(summary = "Update marks and grade of a result")
    @PutMapping("/{id}")
    public ResponseEntity<Result> updateResultMarks(
            @PathVariable Long id,
            @RequestParam Integer marks
    ) {
        return ResponseEntity.ok(service.update(id, marks));
    }

    @Operation(summary = "Delete a result record")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
