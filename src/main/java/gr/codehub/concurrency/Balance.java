package gr.codehub.concurrency;

//implements the shared resource
public class Balance {

    private double balance;

    public Balance(double balance) {
        this.balance = balance;
    }

    public Balance() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
