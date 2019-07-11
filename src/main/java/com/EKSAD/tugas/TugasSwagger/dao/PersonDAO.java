package com.EKSAD.tugas.TugasSwagger.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.EKSAD.tugas.TugasSwagger.model.Person;

public interface PersonDAO extends PagingAndSortingRepository<Person, Long>{

}
