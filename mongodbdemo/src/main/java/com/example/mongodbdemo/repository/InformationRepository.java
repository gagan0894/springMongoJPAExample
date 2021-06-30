package com.example.mongodbdemo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongodbdemo.model.Information;

public interface InformationRepository extends MongoRepository<Information,String>{
	
	@Query("{'name': ?0}")
	Optional<Information> findByName(String name);

}
