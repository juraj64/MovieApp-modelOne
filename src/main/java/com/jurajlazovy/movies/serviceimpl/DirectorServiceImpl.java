package com.jurajlazovy.movies.serviceimpl;

import com.jurajlazovy.movies.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jurajlazovy.movies.domain.Gender.F;
import static org.sculptor.framework.accessapi.ConditionalCriteriaBuilder.criteriaFor;

/**
 * Implementation of DirectorService.
 */
@Service("directorService")
public class DirectorServiceImpl extends DirectorServiceImplBase {

    public DirectorServiceImpl() {
    }

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> findDirectorsByCondition(ServiceContext ctx) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = sdf.parse("1980-01-01");

        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Director.class)
                .withProperty(DirectorProperties.dateOfBirth()).lessThan(date) // starsi ako
                .orderBy(DirectorProperties.lastName()).build(); // zorad vsetkych podla lastName

        return directorRepository.findByCondition(criteria);
    }

    @Override
    public List<Director> findDirectorsByBirth(ServiceContext ctx, Date dateOfBirth) {
        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Director.class)
                .withProperty(DirectorProperties.dateOfBirth()).lessThan(dateOfBirth) // starsi ako
                .orderBy(DirectorProperties.lastName()).build(); // zorad vsetkych podla lastName

        return directorRepository.findByCondition(criteria);
    }

    @Override
    public List<Director> findAllDirectorsOrdered(ServiceContext ctx) {
        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Director.class)
                .orderBy(DirectorProperties.lastName())           // zorad vsetkych podla lastName
                .orderBy(DirectorProperties.firstName()).build(); // a nasledne firstName

        return directorRepository.findByCondition(criteria);
    }

    @Override
    public List<Director> findRussianDirectors(ServiceContext ctx) {
        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Director.class)
                .withProperty(DirectorProperties.nationality()).eq("Russian") // ruski reziseri
                .orderBy(DirectorProperties.lastName()).build(); // zorad vsetkych podla lastName

        return directorRepository.findByCondition(criteria);
    }

    @Override
    public List<Director> findDirectorsByNationality(ServiceContext ctx, String nationality) {
        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Director.class)
                .withProperty(DirectorProperties.nationality()).eq(nationality) // danej nationality
                .orderBy(DirectorProperties.lastName()).build(); // zorad vsetkych podla lastName

        return directorRepository.findByCondition(criteria);
    }

}
