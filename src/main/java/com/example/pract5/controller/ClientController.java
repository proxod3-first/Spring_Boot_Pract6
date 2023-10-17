package com.example.pract5.controller;

import com.example.pract5.controller.template.AbstractController;
import com.example.pract5.entity.ClientEntity;
import com.example.pract5.form.ClientForm;
import com.example.pract5.service.ClientService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clients")
public class ClientController extends AbstractController<ClientEntity, ClientService, ClientForm> {


    public ClientController(ClientService service) {
        super(service);
    }
}
