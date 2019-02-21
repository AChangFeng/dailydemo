package wind.netty;

import wind.netty.time.TimeServerHandler;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-20 09:44
 **/
public class ServerDemo {

    public static void main(String[] args) throws Exception {
        Server server = ServerFactory.getServer(new TimeServerHandler());
        server.run();
    }

}
