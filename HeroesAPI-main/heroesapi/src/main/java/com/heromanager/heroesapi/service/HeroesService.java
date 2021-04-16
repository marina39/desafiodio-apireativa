package com.heromanager.heroesapi.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.heromanager.heroesapi.document.Heroes;
import com.heromanager.heroesapi.repository.HeroesRepository;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public Flux<Heroes> findAll() {
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public Mono<Heroes> findById(String id) {
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes heroes) {
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<Boolean> deleteById(String id) {
        heroesRepository.deleteById(id);
        return Mono.justOrEmpty(true);
    }

}
