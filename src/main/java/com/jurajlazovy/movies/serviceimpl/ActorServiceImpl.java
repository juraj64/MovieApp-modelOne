package com.jurajlazovy.movies.serviceimpl;

import com.jurajlazovy.movies.domain.*;

import java.util.List;

import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jurajlazovy.movies.domain.Gender.F;
import static com.jurajlazovy.movies.domain.Gender.M;

/**
 * Implementation of ActorService.
 */
@Service("actorService")
public class ActorServiceImpl extends ActorServiceImplBase {

    public ActorServiceImpl() {
    }

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> findActorsByCondition(ServiceContext ctx) {
        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Actor.class)
                .withProperty(ActorProperties.gender()).eq(F)
                // vsetky zeny (F som dal cez possibilities, inak bol problem)
                .orderBy(ActorProperties.lastName()).build(); // zorad vsetkych podla lastName

        return actorRepository.findByCondition(criteria);
    }

    @Override
    public List<Actor> findActorsByGender(ServiceContext ctx, Gender gender) {
        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Actor.class)
                .withProperty(ActorProperties.gender()).eq(gender) // podla genderu
                .orderBy(ActorProperties.lastName()).build(); // zorad vsetkych podla lastName

        return actorRepository.findByCondition(criteria);
    }

}
