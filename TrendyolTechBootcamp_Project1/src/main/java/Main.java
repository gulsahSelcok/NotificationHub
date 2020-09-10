import Models.*;

import java.util.*;
import java.util.Date;

class Main {
public  static  void main(String[] args){

    Scanner in = new Scanner(System.in);
    Company company = new Company();
    company.setNumberOfSmsNotifications(0);
    company.setNumberOfEmailNotifications(0);
    int selection;
    boolean isInTheLoop = true;
    boolean isSMSPackageSelected = false;
    boolean isEMailPackageSelected= false;

    //SMS ve Email gönderimi için içerikleri dolduralım.
    Sms sms = new Sms();
    SmsDTO smsDto = new SmsDTO();
    smsDto.setContent("SMS içeriği..") ;
    smsDto.setFrom(company.getCompanyName());
    String[] phoneNumberList = new String[]{"05393777299", "05368963652"};
    smsDto.setPhoneNumber(phoneNumberList) ;
    int smsNotificationQuantity = smsDto.getPhoneNumber().length;

    EMail eMail = new EMail();
    EMailDTO eMailDto = new EMailDTO();
    eMailDto.setContent("EMail içeriği..") ;
    eMailDto.setFrom(company.getCompanyName());
    String[] mailList = new String[]{"x@hotmail.com", "y@gmail.com"};
    eMailDto.setEmailAdress(mailList); ;
    int emailNotificationQuantity = eMailDto.getEmailAdress().length;

    System.out.println("Firma adınız: ");
    company.setCompanyName(in.nextLine());

    //Aşağıda kullanıcının kayıt olduğu tarihi atadık. Faturalama ve kara listeye girme bu tanımlamadan yola çıkılarak yapılacak.
    Date subscriptionDate = new GregorianCalendar(2020,2,19,00,00).getTime();
    company.setSubscriptionDate(subscriptionDate);

    //SMS ve Email paketleri için abonelik alalım.

    while(isInTheLoop) {

        System.out.println("Paket seçiniz: \n 1- SMS Sabit Kotalı \n 2- SMS Esnek Kotalı\n 3-SMS Paketi almak istemiyorum.");
        selection = in.nextInt();

        switch (selection) {
            case 1:
                if (company.isSmsFixed() == false) {
                    company.setSmsFixed(true);
                    isSMSPackageSelected = true;
                }
                else
                    System.out.println("Bu seçenek sepetinizde mevcut, aynı ürünü birden fazla kez ekleyemezsiniz.");
                continue;

            case 2:
                if (company.isSmsFlexible() == false) {
                    company.setSmsFlexible(true);
                    isSMSPackageSelected = true;
                }
                else
                    System.out.println("Bu seçenek sepetinizde mevcut, aynı ürünü birden fazla kez ekleyemezsiniz.");
                continue;

            case 3:
                isInTheLoop=false;
                isSMSPackageSelected=false;
                break;

            default:
                System.out.println("Hatali secim! Belirtilen aralıkta bir değer seçiniz.");
                continue;
        }

    }
    isInTheLoop=true;

    while(isInTheLoop) {

        System.out.println("Paket seçiniz: \n 1- EMail Sabit Kotalı \n 2- EMail Esnek Kotalı\n 3-EMail Paketi almak istemiyorum.");
        selection = in.nextInt();

        switch (selection) {
            case 1:
                if (company.isEmailFixed() == false) {
                    company.setSmsFixed(true);
                    isEMailPackageSelected = true;
                }
                else
                    System.out.println("Bu seçenek sepetinizde mevcut, aynı ürünü birden fazla kez ekleyemezsiniz.");
                continue;

            case 2:
                if (company.isEmailFlexible() == false) {
                    company.setSmsFlexible(true);
                    isEMailPackageSelected = true;
                }
                else
                    System.out.println("Bu seçenek sepetinizde mevcut, aynı ürünü birden fazla kez ekleyemezsiniz.");
                continue;

            case 3:
                isInTheLoop=false;
                isEMailPackageSelected=false;
                break;

            default:
                System.out.println("Hatali secim! Belirtilen aralıkta bir değer seçiniz.");
                continue;
        }
    }

    isInTheLoop=true;

    //Bu kısımda şirket bildirim gönderme işlemine başlayabilir.

    while(isInTheLoop){
        System.out.println("Bildirim göndermek ister misiniz? \n 1-Evet \n 2-Hayır ");
        selection = in.nextInt();
        switch(selection){
            case 1:
                if (isSMSPackageSelected == true && isEMailPackageSelected == true){//Şirket hem email gönderim hem de sms gönderim paketi aldıysa
                    sms.SendSMS(company,smsDto);    //SMS gönder.
                    company.setNumberOfSmsNotifications(company.getNumberOfSmsNotifications() + smsNotificationQuantity);//Şirketin sms gönderim bilgisini kaç adet gönderim yaptıysa o kadar artır.
                    eMail.SendEMail(company, eMailDto);  //EMail gönder.
                    company.setNumberOfEmailNotifications(company.getNumberOfEmailNotifications() + emailNotificationQuantity);//Şirketin email gönderim bilgisini kaç adet gönderim yaptıysa o kadar artır.
                }
                else if(isSMSPackageSelected == true  && isEMailPackageSelected ==false){//Şirket sadece SMS paketi aldıysa
                    sms.SendSMS(company,smsDto);
                    company.setNumberOfSmsNotifications(company.getNumberOfSmsNotifications()+smsNotificationQuantity);
                }
                else{//Şirket sadece EMail paketi aldıysa
                    eMail.SendEMail(company,eMailDto);
                    company.setNumberOfEmailNotifications(company.getNumberOfEmailNotifications()+emailNotificationQuantity);
                }
                continue;

            case 2:
                isInTheLoop=false;
                break;
        }
    }

}
}
