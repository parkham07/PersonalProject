package kr.co.parkham.config.websocket;

import kr.co.parkham.controller.websocket.Socket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SocketPool {
    protected static Set<Socket> listeners = new CopyOnWriteArraySet<>();
    private static int onlineCount = 0;

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
