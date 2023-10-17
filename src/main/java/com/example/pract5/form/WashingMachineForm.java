package com.example.pract5.form;

import com.example.pract5.form.template.AbstractProductForm;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WashingMachineForm extends AbstractProductForm {

    @NotNull(message = "Поле manufacturer не может быть пустым")
    private String manufacturer;

    @NotNull(message = "Поле tank_capacity не может быть пустым")
    private Integer tank_capacity;

}
