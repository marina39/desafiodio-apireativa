package com.heromanager.heroesapi.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.heromanager.heroesapi.document.Heroes;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {


}
