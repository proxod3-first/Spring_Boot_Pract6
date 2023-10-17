package com.example.pract5.service;

import com.example.pract5.entity.ClientEntity;
import com.example.pract5.form.ClientForm;
import com.example.pract5.repository.ClientRepo;
import com.example.pract5.service.template.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<ClientEntity, ClientRepo, ClientForm> {

    public ClientService(ClientRepo repo) {
        super(repo);
    }

    @Override
    public void createOne(ClientForm form) {
        ClientEntity entity = new ClientEntity();
        entity.update(form);
        repo.save(entity);
    }
}
