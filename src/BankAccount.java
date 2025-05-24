import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankAccount extends UnicastRemoteObject implements IBankAccount {
    private double cash;

    protected BankAccount() throws RemoteException {
        super();
    }

    public String deposit(double value) {
        this.cash += value;
        return "Value deposited successfully";
    }

    public String withdraw(double value) {
        var newCash = cash - value;
        if (newCash < 0) {
            return "Insufficient balance!";
        }
        this.cash = newCash;
        return "Amount draw successfully!";
    }

    public String balance() {
        return "Your balance is $" + this.cash;
    }
}
