package com.example.pract5.controller;

import com.example.pract5.controller.template.AbstractController;
import com.example.pract5.entity.BookEntity;
import com.example.pract5.form.BookForm;
import com.example.pract5.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController extends AbstractController<BookEntity, BookService, BookForm> {


    public BookController(BookService service) {
        super(service);
    }
}
