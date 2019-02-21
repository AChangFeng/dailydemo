package wind.netty;

import io.netty.channel.ChannelInboundHandler;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-20 09:41
 **/
public class ServerFactory {

    public static Server getServer(ChannelInboundHandler handler) {
        return new Server(8080, handler);
    }

    public static Server getServer(int port, ChannelInboundHandler handler) {
        return new Server(port, handler);
    }

}
