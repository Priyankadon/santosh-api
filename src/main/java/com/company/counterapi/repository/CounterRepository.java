package com.company.counterapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.counterapi.entity.CounterEntity;

public interface CounterRepository extends JpaRepository<CounterEntity, String> {

}
