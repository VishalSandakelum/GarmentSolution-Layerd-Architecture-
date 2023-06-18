package lk.ijse.garment.controller;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class qrsender {
    public void send(String subject, String msg, String tocus, String imagePath) {
        String to = tocus;
        String from = "intexvog20@gmail.com";
        String host = "smtp.gmail.com";
        String password = "lshiqucrerfrtnhv";


        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(msg);

            multipart.addBodyPart(textPart);

            MimeBodyPart imagePart = new MimeBodyPart();
            DataSource source = new FileDataSource(imagePath);
            imagePart.setDataHandler(new DataHandler(source));
            imagePart.setFileName(imagePath);

            multipart.addBodyPart(imagePart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Message sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        qrsender q1 = new qrsender();
        q1.send("qr","ok","kavinduhansaka1011@gmail.com","D:\\Garmentsolution(s.f.w)\\src\\main\\resources\\imgs\\qrnewone.png");
    }*/
}
