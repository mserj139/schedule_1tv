package com.website._1tv.repository;

import com.website._1tv.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Message, Integer> {

}
