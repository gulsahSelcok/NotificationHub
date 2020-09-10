package Models;

public class EMailDTO {

    public String content;
    private String from;
    private String emailAdress[];

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String[] emailAdress) {
        this.emailAdress = emailAdress;
    }


}
