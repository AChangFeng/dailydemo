package wind.netty;

import wind.netty.time.TimeClientHandler;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-20 15:53
 **/
public class ClientDemo {

    public static void main(String[] args) throws Exception {
        Client client = ClientFactory.getClient(new TimeClientHandler());
        client.run();
    }

}
