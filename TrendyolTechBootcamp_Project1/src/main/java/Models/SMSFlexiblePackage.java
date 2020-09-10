package Models;

public class SMSFlexiblePackage implements IPackage {
    static final int quota=2000;
    static final int packagePrice= 30;
    static final float perSMSPrice= (float) 0.1;

    public int CalculateQuotaOverrun() {
        return 0;
    }

    public int CalculateInvoice() {
        return 0;
    }
}
