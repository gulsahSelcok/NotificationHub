package Models;

public class EMailFlexiblePackage implements IPackage{
    static final int quota=2000;
    static final float packagePrice= (float) 7.5;
    static final float perMailPrice= (float) 0.03;

    public int CalculateQuotaOverrun() {
        return 0;
    }

    public int CalculateInvoice() {
        return 0;
    }
}
