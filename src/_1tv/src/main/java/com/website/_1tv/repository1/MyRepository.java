package com.website._1tv.repository1;

import com.website._1tv.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyRepository extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);
}
