package model;

public class Role {
    private String cashier,waiter,cleaner;

    public Role(String cashier, String waiter, String cleaner) {
        this.cashier = cashier;
        this.waiter = waiter;
        this.cleaner = cleaner;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public String getCleaner() {
        return cleaner;
    }

    public void setCleaner(String cleaner) {
        this.cleaner = cleaner;
    }
}
