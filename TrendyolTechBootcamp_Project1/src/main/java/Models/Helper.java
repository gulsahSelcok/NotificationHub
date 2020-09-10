package Models;

import java.util.Date;

public class Helper {

    //Bu metodla fatura tarihinde gecikmenin kaç ay old. buluyoruz.

    public long MonthCalculation(Date subscriptionDate){
        Date now = new Date();
        long month = ((now.getTime() - subscriptionDate.getTime())/(1000*60*60*24)+30)/30;
        return month;
    }
}
