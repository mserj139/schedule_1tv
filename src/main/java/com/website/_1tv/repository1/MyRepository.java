package com.website._1tv.repository1;

import com.website._1tv.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MyRepository extends CrudRepository<Message, Integer> {

}
