package wind.se;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-06 11:00
 **/
public class Client {

    public static Client client = new Client();

    public static int a;
    public static int b = 0;

    private Client() {
        a++;
        b++;
    }

    public static Client getClient() {
        return client;
    }

    public static void main(String[] args) {
        Client client = Client.getClient();
        System.out.println(Client.a);
        System.out.println(Client.b);
    }

}
