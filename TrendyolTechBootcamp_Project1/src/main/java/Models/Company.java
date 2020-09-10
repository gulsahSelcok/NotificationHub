package Models;

import java.util.Date;

public class Company {
    private String companyName;
    private Date subscriptionDate;
    private int numberOfSmsNotifications;
    private int numberOfEmailNotifications;
    private boolean isInBlackList = false;
    private boolean smsFixed = false;
    private boolean smsFlexible= false;
    private boolean emailFixed= false;
    private boolean emailFlexible= false;

    public int getNumberOfSmsNotifications() {
        return numberOfSmsNotifications;
    }

    public void setNumberOfSmsNotifications(int numberOfSmsNotifications) {
        this.numberOfSmsNotifications = numberOfSmsNotifications;
    }

    public int getNumberOfEmailNotifications() {
        return numberOfEmailNotifications;
    }

    public void setNumberOfEmailNotifications(int numberOfEmailNotifications) {
        this.numberOfEmailNotifications = numberOfEmailNotifications;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String name) {
        this.companyName = name;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public boolean isInBlackList() {

        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.isInBlackList = inBlackList;
    }

    public boolean isSmsFixed() {
        return smsFixed;
    }

    public void setSmsFixed(boolean smsFixed) {
        this.smsFixed = smsFixed;
    }

    public boolean isSmsFlexible() {
        return smsFlexible;
    }

    public void setSmsFlexible(boolean smsFlexible) {
        this.smsFlexible = smsFlexible;
    }

    public boolean isEmailFixed() {
        return emailFixed;
    }

    public void setEmailFixed(boolean emailFixed) {
        this.emailFixed = emailFixed;
    }

    public boolean isEmailFlexible() {
        return emailFlexible;
    }

    public void setEmailFlexible(boolean emailFlexible) {
        this.emailFlexible = emailFlexible;
    }

}
