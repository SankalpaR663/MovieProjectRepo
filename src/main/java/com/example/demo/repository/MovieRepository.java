package com.example.demo.repository;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.MovieEntity;
import com.example.demo.enums.MovieLanguage;

@Resource
@RepositoryRestResource(path = "movie")
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> 
{

	boolean existsByNameAndLanguage(String name, MovieLanguage language);
}