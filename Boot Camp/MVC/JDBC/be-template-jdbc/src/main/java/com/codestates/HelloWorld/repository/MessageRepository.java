package com.codestates.HelloWorld.repository;

import com.codestates.HelloWorld.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}