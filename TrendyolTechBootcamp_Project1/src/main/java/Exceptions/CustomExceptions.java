package Exceptions;

public class CustomExceptions {
    public static void canSend(long month) throws SMSSendExceptions{
        if(month>2)
            throw new SMSSendExceptions("Ödenmemiş faturalarınız mevcuttur. Sms gönderimi borcunuzu ödemeden yapılamaz.");
        else
            System.out.println("Gönderim başarılı");
    }
}
