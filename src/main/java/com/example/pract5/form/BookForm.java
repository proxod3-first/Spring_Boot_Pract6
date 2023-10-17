package com.example.pract5.form;

import com.example.pract5.form.template.AbstractProductForm;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookForm extends AbstractProductForm {

    @NotNull(message = "Поле author не может быть пустым")
    private String author;

}
