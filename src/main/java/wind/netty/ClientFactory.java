package wind.netty;

import io.netty.channel.ChannelInboundHandler;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-20 15:44
 **/
public class ClientFactory {

    public static Client getClient(ChannelInboundHandler handler) {
        return new Client("localhost", 8080, handler);
    }

    public static Client getClient(String host, int port, ChannelInboundHandler handler) {
        return new Client(host, port, handler);
    }

}
