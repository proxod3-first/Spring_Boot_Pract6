package com.example.pract5.controller;

import com.example.pract5.controller.template.AbstractController;
import com.example.pract5.entity.WashingMachineEntity;
import com.example.pract5.form.WashingMachineForm;
import com.example.pract5.service.WashingMachineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/washing_machines")
public class WashingMachineController extends AbstractController<WashingMachineEntity, WashingMachineService, WashingMachineForm> {


    public WashingMachineController(WashingMachineService service) {
        super(service);
    }
}
