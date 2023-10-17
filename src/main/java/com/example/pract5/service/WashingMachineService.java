package com.example.pract5.service;

import com.example.pract5.entity.WashingMachineEntity;
import com.example.pract5.form.WashingMachineForm;
import com.example.pract5.repository.WashingMachineRepo;
import com.example.pract5.service.template.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class WashingMachineService extends AbstractService<WashingMachineEntity, WashingMachineRepo, WashingMachineForm> {

    public WashingMachineService(WashingMachineRepo repo) {
        super(repo);
    }

    @Override
    public void createOne(WashingMachineForm form) {
        WashingMachineEntity entity = new WashingMachineEntity();
        entity.update(form);
        repo.save(entity);
    }
}
