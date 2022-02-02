package kr.co.parkham.controller.websocket;

import kr.co.parkham.config.websocket.Message;
import kr.co.parkham.config.websocket.MessageDecoder;
import kr.co.parkham.config.websocket.MessageEncoder;
import kr.co.parkham.config.websocket.SocketPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@Component
@ServerEndpoint(value = "/websocket/{username}",
                encoders = MessageEncoder.class,
                decoders = MessageDecoder.class
)
public class Socket extends SocketPool {
    private Session session;

    @OnOpen //클라이언트가 소켓에 연결될 때 마다 호출
    public void onOpen(Session session, @PathParam("username") String username) {
        log.info(session.getId() + " : onOpen called()...");
        addOnlineCount();
        this.session = session;
        listeners.add(this);

        Message message = new Message();

        message.setFrom(username);
        message.setContent("connected");

        broadcast(message);
    }

    @OnClose //클라이언트와 소켓의 연결이 닫힐 때 (끊길 때) 마다 호출
    public void onClose() {
        log.info(this.session.getId() + " : onClose called()...");
        subOnlineCount();
        listeners.remove(this);
    }

    @OnMessage
    public void onMessage(Message message) {
        log.info(this.session.getId() + " : onMessage called()...");
        broadcast(message);
    }

    private static void broadcast(Message message) {
        listeners.forEach(endPoint -> {
            synchronized (endPoint) {
                try {
                    endPoint.session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
//        for (Socket listener : listeners) {
//            listener.sendMessage(message);
//        }
    }

    private void sendMessage(String message) {
        try {
            log.info(this.session.getId() + " : sendMessage called()...");
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("Caught exception while sending message to Session " + this.session.getId(), e.getMessage(), e);
        }
    }

    @OnError
    public void onError(Throwable throwable) {
        log.error(this.session.getId() + " : onError called()...");
    }
}
