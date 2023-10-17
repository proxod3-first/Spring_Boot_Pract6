package com.example.pract5.service;

import com.example.pract5.entity.BookEntity;
import com.example.pract5.form.BookForm;
import com.example.pract5.repository.BookRepo;
import com.example.pract5.service.template.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService<BookEntity,BookRepo,BookForm> {

    public BookService(BookRepo repo) {
        super(repo);
    }

    @Override
    public void createOne(BookForm form) {
        BookEntity entity = new BookEntity();
        entity.update(form);
        repo.save(entity);
    }
}
