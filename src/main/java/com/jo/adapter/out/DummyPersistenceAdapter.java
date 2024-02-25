package com.jo.adapter.out;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.data.domain.Pageable;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jo.adapter.out.utils.Paginator;
import com.jo.application.out.QueryDummy;
import com.jo.application.out.SaveDummy;
import com.jo.common.annotation.PersistenceAdapter;
import com.jo.common.exception.NotFoundException;
import com.jo.common.response.Pagination;
import com.jo.domain.model.Dummy;

import lombok.AllArgsConstructor;

@PersistenceAdapter
@AllArgsConstructor
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class DummyPersistenceAdapter implements QueryDummy, SaveDummy {
    
    private final DummyEntityRepository dummyEntityRepository;

    @Override
    public Dummy findById(int id) {
        return dummyEntityRepository
                .findById(id)
                .map(DummyMapper::entityToDomain)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Dummy save(Dummy dummy) {
        var dummyEntity = DummyMapper.domainToEntity(dummy);
        dummy = DummyMapper.entityToDomain(dummyEntityRepository.save(dummyEntity));
        return dummy;
    }

    @Override
    public ImmutablePair<Pagination, List<Dummy>> findAll(Pageable pageable) {
        var page = dummyEntityRepository.findAll(pageable);
        return Paginator.create(page, DummyMapper::entityToDomain);
    }
}
