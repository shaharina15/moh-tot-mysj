package org.totmysj.service;

import org.totmysj.models.EmailMessage;

public interface MailSender
{
    void sendMail(EmailMessage emailMessage);
}
