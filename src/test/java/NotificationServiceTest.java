import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

    @Mock
    private PidgeonService pidgeonService;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void shouldSendEmailWhenEmailServiceIsAvailable() {
        when(emailService.isAvailable()).thenReturn(true);
        notificationService.sendNotification();
        verify(emailService).sendEmail("Wysłano wiadomość email");
    }

    @Test
    public void shouldSendMessageWhenPidgeonServiceIsAvailable(){
        when(pidgeonService.isAvailable()).thenReturn(true);
        notificationService.sendNotification();
        verify(pidgeonService).sendMessage("Wysłano wiadomość gołębiem");
    }







}