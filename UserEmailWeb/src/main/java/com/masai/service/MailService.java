package com.masai.service;

import java.util.List;

import com.masai.module.Mail;

public interface MailService {

    public List<Mail> inbox();

    public List<Mail> sentBox();

    public List<Mail> getAllMail();

    
    public List<Mail> getDeletedMails();
    
    public List<Mail> getStarredMails();


}
