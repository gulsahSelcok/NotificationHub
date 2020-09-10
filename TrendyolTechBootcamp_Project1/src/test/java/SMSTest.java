import Models.Sms;
import Models.SmsDTO;
import org.junit.jupiter.api.Test;
import  static org.assertj.core.api.Assertions.assertThat;

public class SMSTest {

    SmsDTO sms = new SmsDTO();

    @Test
    public void it_should_return_formatted_phone(){
        //Given
            String phone = "05369874152";
        //When
         String[] formattedPhone = sms.getPhoneNumber();
        //Then
        assertThat(formattedPhone).isEqualTo(phone);
    }

    public void it_should_return_formatted_notification(){
        //Given
        String notification = "Selam kullanıcı.";
        //When
        Boolean formattedNotification = sms.ValidateNotification(notification);
        //Then
        assertThat(formattedNotification).isEqualTo(formattedNotification);
    }
}
