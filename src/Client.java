import java.rmi.Naming;

public class Client {
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

            IBankAccount ba = (IBankAccount) Naming.lookup("rmi://" + ip + ":" + port + "/BankService");

            System.out.println("Testing deposit a value");
            System.out.printf(ba.deposit(100));

            System.out.println("Testing withdraw a valid value");
            System.out.printf(ba.withdraw(20));

            System.out.println("Testing withdraw invalid value");
            System.out.printf(ba.withdraw(10000));

            System.out.println("Testing the balance");
            System.out.printf(ba.balance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
