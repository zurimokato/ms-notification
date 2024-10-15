package com.local.ms_notification.application.port.out;

import com.local.ms_notification.infrastructure.adapter.out.listener.entity.Order;
import jakarta.mail.MessagingException;

public interface MailSenderOutPutPort {

    public void sendEmail(Order order) throws MessagingException;
}
