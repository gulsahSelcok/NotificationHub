package Models;


public class SMSFixedPackage implements IPackage {

    static final int quota=1000;
    static final int packagePrice= 20;
    static final float perMailPrice= (float) 0.03;

    public int CalculateQuotaOverrun() {
        return 0;
    }

    public int CalculateInvoice() {
        return 0;
    }
}
