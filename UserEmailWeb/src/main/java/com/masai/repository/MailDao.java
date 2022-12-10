package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.module.Mail;
import com.masai.module.User;

@Repository
public interface MailDao extends JpaRepository<Mail, Integer> {

	List<Mail> findByRecievers(User user);

}
