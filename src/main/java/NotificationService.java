import javax.management.ServiceNotFoundException;

public class NotificationService {

        private PidgeonService pigeonService;
        private EmailService emailService;

    public NotificationService(PidgeonService pigeonService, EmailService emailService) {
        this.pigeonService = pigeonService;
        this.emailService = emailService;
    }

    public void sendNotification() {
            if (emailService.isAvailable()) {
                emailService.sendEmail("Wysłano wiadomość email");
            } else if (pigeonService.isAvailable()) {
                pigeonService.sendMessage("Wysłano wiadomość gołębiem");
            } else {
                throw new RuntimeException("Serwis niedostępny");
            }
        }
    }

