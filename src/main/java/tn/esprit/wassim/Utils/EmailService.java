package tn.esprit.wassim.Utils;

import tn.esprit.wassim.Entity.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    public String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment

}
