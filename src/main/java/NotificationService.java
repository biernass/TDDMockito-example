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
            emailService.sendEmail("send email");
        } else if (pigeonService.isAvailable()) {
            pigeonService.sendMessage("send pigeon");
        } else {
            throw new IllegalStateException("services unavailable");
        }
    }
}

