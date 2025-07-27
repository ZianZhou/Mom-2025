package com.zian.jaroflove.repository;

import com.zian.jaroflove.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
