package com.example.pract5.service.template;

import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.exception.NotFoundException;
import com.example.pract5.repository.template.CommonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public abstract class AbstractService<E extends AbstractEntity<F>, R  extends CommonRepo<E>,F> implements CommonService<E,F> {


    protected final R repo;

    @Autowired
    public AbstractService(R repo) {
        this.repo = repo;
    }

    public List<E> getAll(){
        List<E> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }


    @Override
    public E getOne(Long id) throws NotFoundException{
        try{
            return repo.findById(id).get();
        }catch (NoSuchElementException e){
            throw new NotFoundException("Книга не найдена");
        }
    }

    @Override
    public E updateOne(Long id, F form) throws NotFoundException {
        E entity = this.getOne(id);
        entity.update(form);
        return repo.save(entity);
    }

    @Override
    public void deleteOne(Long id) throws NotFoundException{
        E entity = this.getOne(id);
        repo.delete(entity);
    }
}
