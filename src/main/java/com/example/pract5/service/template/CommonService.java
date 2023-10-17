package com.example.pract5.service.template;

import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.exception.NotFoundException;

import java.util.List;

public interface CommonService<E extends AbstractEntity<F>, F>{
    List<E> getAll();

    E getOne(Long id) throws NotFoundException;
    void createOne(F form);

    E updateOne(Long id,F form) throws NotFoundException;

    void deleteOne(Long id) throws NotFoundException;
}
