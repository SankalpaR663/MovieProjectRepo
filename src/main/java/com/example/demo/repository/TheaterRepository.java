package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TheaterEntity;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Long>, JpaSpecificationExecutor<TheaterEntity> {

}