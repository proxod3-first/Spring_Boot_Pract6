package com.example.pract5.form;

import com.example.pract5.form.template.AbstractProductForm;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelephoneForm extends AbstractProductForm {

    @NotNull(message = "Поле manufacturer не может быть пустым")
    private String manufacturer;

    @NotNull(message = "Поле battery_capacity не может быть пустым")
    private Integer battery_capacity;

}
