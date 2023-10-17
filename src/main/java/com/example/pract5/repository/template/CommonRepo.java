package com.example.pract5.repository.template;

import com.example.pract5.entity.template.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepo<T extends AbstractEntity> extends CrudRepository<T, Long> {
}
