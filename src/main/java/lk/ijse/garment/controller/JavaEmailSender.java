package lk.ijse.garment.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaEmailSender {

    public void  JavaEmailSender() {



    }

    public void send(String subject,String msg,String tocus){
        String to = tocus; // recipient email address
        String from = "intexvog20@gmail.com"; // sender email address
        String host = "smtp.gmail.com"; // Gmail SMTP server host name
        String password = "lshiqucrerfrtnhv"; // Gmail password

        // Set properties
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // Gmail SMTP port number
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        // Get session
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(msg);

            // Send message
            Transport.send(message);
            System.out.println("Message sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}

