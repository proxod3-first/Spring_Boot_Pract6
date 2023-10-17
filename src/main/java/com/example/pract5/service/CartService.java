package com.example.pract5.service;

import com.example.pract5.entity.*;
import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.entity.template.AbstractProductEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.exception.AlreadyExistException;
import com.example.pract5.exception.OrderException;
import com.example.pract5.exception.WrongAmount;
import com.example.pract5.exception.NotFoundException;
import com.example.pract5.form.CartForm;
import com.example.pract5.repository.*;
import com.example.pract5.view.CartView;
import com.example.pract5.view.GoodInCartView;
import com.example.pract5.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    protected ClientRepo clientRepo;

    @Autowired
    protected CartRepo cartRepo;

    @Autowired
    protected BookRepo bookRepo;

    @Autowired
    protected TelephoneRepo telephoneRepo;

    @Autowired
    protected WashingMachineRepo washingMachineRepo;

    private AbstractProductEntity getProduct(Long good_id, Type type){
        AbstractProductEntity product = null;
        if (type == Type.Books){
            product = bookRepo.findById(good_id).orElse(null);
        }

        if (type == Type.Electronics){
            product = telephoneRepo.findById(good_id).orElse(null);
        }

        if (type == Type.Plumbing){
            product = washingMachineRepo.findById(good_id).orElse(null);
        }

        return product;
    }

    public GoodInCartView addGood(Long client_id, CartForm form) throws WrongAmount, NotFoundException, AlreadyExistException {
        ClientEntity client = clientRepo.findById(client_id).orElse(null);
        if (client == null) {
            throw new NotFoundException("Корзина пользователя не найдена");
        }

        CartEntity product = cartRepo.findByGoodIdAndGoodTypeAndClient_id(form.getId_good(), form.getGood_type(), client_id);
        if (product != null){
            throw new AlreadyExistException("Товар уже в корзине");
        }


        AbstractProductEntity good = this.getProduct(form.getId_good(), form.getGood_type());
        if (good == null) {
            throw new NotFoundException("Товар не найден");
        }

        if (good.getAmount() == 0){
            throw new WrongAmount("Товара нет в наличии");
        }

        CartEntity newGood = new CartEntity();
        newGood.setGoodType(form.getGood_type());
        newGood.setGoodId(form.getId_good());
        newGood.setClient(client);

        GoodInCartView view = new GoodInCartView();
        view.update(cartRepo.save(newGood));
        return view;

    }

    public void deleteGood(Long client_id, Long good_id, Type type) throws NotFoundException {
        CartEntity product = cartRepo.findByGoodIdAndGoodTypeAndClient_id( good_id, type, client_id);
        if (product == null){
            throw new NotFoundException("Товар не найден");
        }

        cartRepo.deleteById(product.getId());

    }

    public CartView getAllGoodsInCart(Long client_id) throws NotFoundException {
        List<CartEntity> goods = cartRepo.findByClient_id(client_id);

        CartView goodsView = new CartView();

        ClientEntity client = clientRepo.findById(client_id).orElse(null);
        if (client == null){
            throw new NotFoundException("Пользователь не найден");
        }
        goodsView.setClient(client);
        AbstractProductEntity product;
        for (CartEntity good: goods){
            product = this.getProduct(good.getGoodId(), good.getGoodType());
            product.setAmount(good.getAmount());
            goodsView.addToCart(product);
        }

        return goodsView;
    }


    public void updateAmountGoodInCart(Long client_id, Long good_id, Type type, Integer amount) throws NotFoundException, WrongAmount {
        CartEntity product = cartRepo.findByGoodIdAndGoodTypeAndClient_id( good_id, type, client_id);
        if (product == null){
            throw new NotFoundException("Товар не найден");
        }

        AbstractProductEntity good = this.getProduct(product.getGoodId(), product.getGoodType());
        if (amount > good.getAmount()){
            throw new WrongAmount("Max amount: "+good.getAmount().toString());
        }

        if (amount < 1){
            throw new WrongAmount("Min amount: 1");
        }


        product.setAmount(amount);
        cartRepo.save(product);
    }

    public OrderView order(Long client_id) throws OrderException, NotFoundException {
        ClientEntity client = clientRepo.findById(client_id).orElse(null);
        if (client == null){
            throw new NotFoundException("Корзина не найдена");
        }

        ArrayList<CartEntity> goods = cartRepo.findByClient_id(client_id);

        if (goods.size() == 0){
            throw new OrderException("Корзина пуста");
        }

        OrderView orderInfo = new OrderView();
        for (CartEntity good: goods){
            AbstractProductEntity product = this.getProduct(good.getGoodId(), good.getGoodType());

            if (good.getAmount() > product.getAmount()){
                throw new OrderException("Невозможно сделать заказ!");
            }
            product.setAmount(good.getAmount());
            orderInfo.addToCart(product);
        }
        cartRepo.deleteAll(goods);
        return orderInfo;
    }
}
