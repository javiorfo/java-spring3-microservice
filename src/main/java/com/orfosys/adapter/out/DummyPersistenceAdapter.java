package com.orfosys.adapter.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.orfosys.common.pagination.Paginator;
import com.orfosys.application.out.FindDummyPersistence;
import com.orfosys.application.out.SaveDummyPersistence;
import com.orfosys.common.annotation.PersistenceAdapter;
import com.orfosys.common.exception.NotFoundException;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;

@PersistenceAdapter
@AllArgsConstructor
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class DummyPersistenceAdapter implements FindDummyPersistence, SaveDummyPersistence {
    
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
    public Paginator.Pair<Dummy> findAll(Pageable pageable) {
        var page = dummyEntityRepository.findAll(pageable);
        return Paginator.create(page, DummyMapper::entityToDomain);
    }
}
