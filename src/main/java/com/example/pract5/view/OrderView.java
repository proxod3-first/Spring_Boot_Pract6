package com.example.pract5.view;

import com.example.pract5.entity.template.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class OrderView {

    private String Status = "Успешно";

    private List<AbstractEntity> cart = new ArrayList<>();

    public void addToCart(AbstractEntity good){
        cart.add(good);
    }
}
