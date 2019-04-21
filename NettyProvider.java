package de.christianbernstein.horizon.provider.network;


import de.christianbernstein.horizon.provider.thread.ProviderThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

public class Provider {

    private static final boolean EPOLL = Epoll.isAvailable(); //todo better doc (print detailed info)
    private static int port;
    private EventLoopGroup eventExecutors;

    public void init(int port){
        //todo validate port using PortValidator.validate
        eventExecutors = EPOLL ? new EpollEventLoopGroup(2, new ProviderThreadFactory("EPOLL_HCP"))
                : new NioEventLoopGroup(2, new ProviderThreadFactory("NIO_HCP"));

    }

    public void boot(){
        try {
            new ServerBootstrap()
                    .group(eventExecutors)
                    .channel(EPOLL ? EpollServerSocketChannel.class : NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline()
                                    .addLast(new StringDecoder(Charset.forName("UTF16")))
                                    .addLast(new StringEncoder(Charset.forName("UTF16")))
                                    .addLast(new NetHandler());
                        }

                    }).bind(port).sync().channel().closeFuture().syncUninterruptibly();
        }catch (Exception ex){
            //Todo log
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }

    public void shutdown(int state){
        //todo log
        eventExecutors.shutdownGracefully();
        Runtime.getRuntime().exit(state);
    }
}
