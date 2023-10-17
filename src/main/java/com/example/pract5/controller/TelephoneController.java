package com.example.pract5.controller;

import com.example.pract5.controller.template.AbstractController;
import com.example.pract5.entity.TelephoneEntity;
import com.example.pract5.form.TelephoneForm;
import com.example.pract5.service.TelephoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telephones")
public class TelephoneController extends AbstractController<TelephoneEntity, TelephoneService, TelephoneForm> {

    public TelephoneController(TelephoneService service) {
        super(service);
    }
}
