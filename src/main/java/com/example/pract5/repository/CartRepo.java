package com.example.pract5.repository;

import com.example.pract5.entity.CartEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.repository.template.CommonRepo;

import java.util.ArrayList;
import java.util.List;

public interface CartRepo extends CommonRepo<CartEntity> {

    CartEntity findByGoodIdAndGoodTypeAndClient_id(Long goodId, Type goodType, Long client_id);

    ArrayList<CartEntity> findByClient_id(Long client_id);
}

