package com.example.pract5.service;

import com.example.pract5.entity.TelephoneEntity;
import com.example.pract5.form.TelephoneForm;
import com.example.pract5.repository.TelephoneRepo;
import com.example.pract5.service.template.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TelephoneService extends AbstractService<TelephoneEntity, TelephoneRepo, TelephoneForm> {
    public TelephoneService(TelephoneRepo repo) {
        super(repo);
    }

    @Override
    public void createOne(TelephoneForm form) {
        TelephoneEntity entity = new TelephoneEntity();
        entity.update(form);
        repo.save(entity);
    }
}
