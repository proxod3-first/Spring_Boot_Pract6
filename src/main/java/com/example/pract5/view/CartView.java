package com.example.pract5.view;

import com.example.pract5.entity.ClientEntity;
import com.example.pract5.entity.template.AbstractProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class CartView {

    private ClientEntity client;

    private ArrayList<Object> cart = new ArrayList<>();

    public void addToCart(AbstractProductEntity good){
        this.cart.add(good);
    }

}
