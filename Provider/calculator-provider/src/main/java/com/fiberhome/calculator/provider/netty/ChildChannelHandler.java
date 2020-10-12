package com.fiberhome.calculator.provider.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.http.protocol.HttpRequestHandler;

/**
 * @author zhoujian
 * @date 2020/8/3
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 设置30秒没有读到数据，则触发一个READER_IDLE事件。
        // pipeline.addLast(new IdleStateHandler(30, 0, 0));
        // HttpServerCodec：将请求和应答消息解码为HTTP消息
        socketChannel.pipeline().addLast("http-codec",new HttpServerCodec());
        // HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息
        socketChannel.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
        // ChunkedWriteHandler：向客户端发送HTML5文件
        socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
        socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
        // 在管道中添加我们自己的接收数据实现方法
        socketChannel.pipeline().addLast("handler",new MyWebSocketServerHandler());
    }
}
