package Models;

import Exceptions.CustomExceptions;

public class EMail{
//Email ile ilgili yapılan tüm işlemler bu sınıfta tutulur.
    Helper helperClass = new Helper();

    public void SendEMail(Company company, EMailDTO email){
        long monthsInDebt = helperClass.MonthCalculation(company.getSubscriptionDate());
        try{
            CustomExceptions.canSend(monthsInDebt); //Fatura iki aydan az süredir gecikmişse ya da hiç gecikme yoksa bildirim gönderimi yapılır.
            System.out.println("Kimden:" + email.getFrom() + "Mesaj:" + email.getContent());
            System.out.println(email.getEmailAdress().length + " adet sms gönderildi.");
        }
        catch(Exception m){  //Fatura iki ay ya da daha fazla süredir ödenmemiş ise.
            System.out.println("Exception occured: "+m);
            company.setInBlackList(true);
        }
    }

    public boolean ValidateNotification(String notification){
        if (notification.isEmpty()){
            return false;
        }
        else {
            return notification.length()<=100 && notification.length()>10;
        }

    }
    public boolean ValidateEmailAddress(String emailAddress){
        return emailAddress.contains("@") && emailAddress.contains(".com");
    }

}
