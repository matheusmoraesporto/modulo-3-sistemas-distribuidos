import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            String ip = System.getenv("RMI_SERVER_IP");
            if (ip == null) {
                throw new IllegalArgumentException("RMI_SERVER_IP env var missing!");
            }

            String port = System.getenv("RMI_SERVER_PORT");
            if (port == null) {
                throw new IllegalArgumentException("RMI_SERVER_PORT env var missing!");
            }

            System.setProperty("java.rmi.server.hostname", ip);
            LocateRegistry.createRegistry(Integer.parseInt(port));

            IBankAccount ba = new BankAccount();
            Naming.rebind("rmi://" + ip + ":" + port + "/BankService", ba);

            System.out.println("Server running.");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
