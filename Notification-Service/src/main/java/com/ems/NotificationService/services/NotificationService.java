package com.ems.NotificationService.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ems.NotificationService.entities.Notification;
import com.ems.NotificationService.repositories.NotificationRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class NotificationService {
	@Autowired
    private NotificationRepository notificationRepository;
	
	@Value("${twilio.phone.number}")
    private String fromNumber;

    public String sendSms(String to, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(fromNumber),
                messageBody
        ).create();

        return message.getSid();
    }

    public Notification sendNotification(Long userId, String message) {
        Notification notification = Notification.builder()
                .userId(userId)
                .message(message)
                .sentAt(new Date())
//                .status(Notification.status.SENT)
                .build();

        // Simulate sending logic (e.g., console log or future email sender)
        System.out.println("Sending notification to User ID " + userId + ": " + message);

        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
