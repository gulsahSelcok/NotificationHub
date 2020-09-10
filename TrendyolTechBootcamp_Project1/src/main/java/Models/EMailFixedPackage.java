package Models;

public class EMailFixedPackage implements IPackage{

    static final int quota = 1000;
    static final int packagePrice = 10;

    public int CalculateQuotaOverrun() {
        return 0;
    }

    public int CalculateInvoice() {
        return 0;
    }
}
