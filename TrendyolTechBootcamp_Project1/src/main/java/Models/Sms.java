package Models;

import Exceptions.CustomExceptions;

public class Sms {
    //Sms ile ilgili yapılan tüm işlemler bu sınıfta tutulur.
    Helper helperClass = new Helper();

    public void SendSMS(Company company, SmsDTO sms) {
        long monthsInDebt = helperClass.MonthCalculation(company.getSubscriptionDate());
        try{
            CustomExceptions.canSend(monthsInDebt);
            System.out.println("Kimden:" + sms.getFrom() + "Mesaj:" + sms.getContent());
            System.out.println(sms.getPhoneNumber().length + " adet sms gönderildi.");
        }
        catch(Exception m){
            System.out.println("Exception occured: "+m);
            company.setInBlackList(true);
        }

        /*if (monthsInDebt < 2) {
            System.out.println("Kimden:" + sms.getFrom() + "Mesaj:" + sms.getContent());
            System.out.println(sms.getPhoneNumber().length + " adet sms gönderildi.");
        } else {
            System.out.println("Ödenmemiş faturalarınız mevcuttur. Sms gönderimi borcunuzu ödemeden yapılamaz.");
            company.setInBlackList(true);
        }*/
    }


    public boolean ValidateNotification(String notification){
        if (notification.isEmpty()){
            return false;
        }
        else {
            return notification.length()<=100 && notification.length()>10;
        }
    }
    public boolean ValidatePhoneNumber(String number){
        return number.length()==11;
    }

 }
