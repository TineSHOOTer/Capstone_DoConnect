package com.DoConnect.services;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
	public boolean sendEmail(String subject, String message, String to) {
        boolean f = false;
        String from = "manprajapati43@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        System.out.println(properties);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "peqoumqfdrausqnb"); 
            }

        });

        session.setDebug(true);
        
        MimeMessage mime = new MimeMessage(session);
        try {
            mime.setFrom(from);
            mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mime.setSubject(subject);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart textBody = new MimeBodyPart();
            try {
                textBody.setText(message);

                multipart.addBodyPart(textBody);

            } catch (Throwable e) {
                e.printStackTrace();
            }
            mime.setContent(multipart,"text/html");

            Transport.send(mime);
            System.out.println("Message Send Successfully!!");
            f=true;

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return f;
	}

}
