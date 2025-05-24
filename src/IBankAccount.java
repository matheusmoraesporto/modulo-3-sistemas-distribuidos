import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBankAccount extends Remote {
    public String deposit(double value) throws RemoteException;
    public String withdraw(double value) throws RemoteException;
    public String balance() throws RemoteException;
}