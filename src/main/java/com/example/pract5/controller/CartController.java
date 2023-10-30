package com.example.pract5.controller;

import com.example.pract5.entity.template.Type;
import com.example.pract5.exception.AlreadyExistException;
import com.example.pract5.exception.NotFoundException;
import com.example.pract5.exception.OrderException;
import com.example.pract5.exception.WrongAmount;
import com.example.pract5.form.CartForm;
import com.example.pract5.service.CartService;
import com.example.pract5.view.OrderView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity getAllGoodsInCart(@RequestParam Long client_id){
        try {
            return ResponseEntity.ok(cartService.getAllGoodsInCart(client_id));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping("/order")
    public ResponseEntity setOrder(@RequestParam Long client_id){
        try {
            OrderView orderInfo = cartService.order(client_id);
            return ResponseEntity.ok(orderInfo);
        }catch(OrderException | NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PostMapping
    public ResponseEntity addGood(@RequestParam Long client_id,
                                  @RequestBody @Valid CartForm form){
        try {
            return ResponseEntity.ok(cartService.addGood(client_id,form));
        } catch (NotFoundException | AlreadyExistException | WrongAmount e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PatchMapping
    public ResponseEntity updateAmountGoodInCart(@RequestParam Long client_id,
                                                 @RequestParam Long good_id,
                                                 @RequestParam Type type,
                                                 @RequestParam Integer amount){
        try {
            cartService.updateAmountGoodInCart(client_id, good_id, type, amount);
            return ResponseEntity.ok("Amount успешно изменен");
        } catch (WrongAmount | NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteGood(@RequestParam Long client_id,
                                     @RequestParam Long good_id,
                                     @RequestParam Type type){
        try {
            cartService.deleteGood(client_id, good_id, type);
            return ResponseEntity.ok("Товар успешно удален из корзины");
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }


}
