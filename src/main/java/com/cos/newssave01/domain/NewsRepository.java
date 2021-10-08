package com.cos.newssave01.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News,String> {

}
