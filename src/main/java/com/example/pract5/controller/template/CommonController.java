package com.example.pract5.controller.template;

import com.example.pract5.entity.template.AbstractEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CommonController<E extends AbstractEntity<F>,F>{
    @GetMapping
    ResponseEntity getAll();

    @GetMapping("/{id}")
    ResponseEntity getOne(@PathVariable Long id);

    @PostMapping
    ResponseEntity<String> createOne(@RequestBody F form);

    @PutMapping("/{id}")
    ResponseEntity<String> updateOne(@PathVariable Long id, @RequestBody @Valid F form);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteOne(@PathVariable Long id);


}
