package com.example.pract5.entity.template;

import com.example.pract5.form.BookForm;
import com.example.pract5.form.template.AbstractProductForm;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Setter
@Getter
public abstract class AbstractEntity<F> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    public abstract void update(F form);

}
