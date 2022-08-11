package com.chat.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

}
