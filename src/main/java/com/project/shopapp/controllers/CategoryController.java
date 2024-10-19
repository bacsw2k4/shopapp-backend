package com.project.shopapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopapp.dtos.CategoryDTO;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/categories")

public class CategoryController {
    // hien thi tat ca categori
    @GetMapping() // http://localhost:8080/api/v1/categories?page=1&limit=10
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit

    ) {

        return ResponseEntity.ok(String.format("getAllCategories,page=%d,limit = %d", page, limit));
    }

    /**
     * @param categoryDTO
     * @param result
     * @return
     */
    @PostMapping()
    public ResponseEntity<?> insertCategories(
            @Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }

        return ResponseEntity.ok("abc " + categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategories(@PathVariable Long id) {
        // TODO: process PUT request

        return ResponseEntity.ok("xyz" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable Long id) {
        // TODO: process PUT request

        return ResponseEntity.ok("cbbb" + id);
    }

}
