package com.example.pract5.view;

import com.example.pract5.entity.CartEntity;
import com.example.pract5.entity.ClientEntity;
import com.example.pract5.entity.template.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodInCartView {

    private Long id;

    private Long goodId;

    @Enumerated(EnumType.STRING)
    private Type goodType;

    private ClientEntity client;
    private Integer amount;

    public void update(CartEntity cart){
        this.id = cart.getId();
        this.goodId = cart.getGoodId();
        this.goodType = cart.getGoodType();
        this.client = cart.getClient();
        this.amount = cart.getAmount();
    }

}
