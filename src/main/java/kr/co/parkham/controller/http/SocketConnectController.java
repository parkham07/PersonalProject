package kr.co.parkham.controller.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;

@Slf4j
@RestController
@RequestMapping(value = "/socketconnect/")
public class SocketConnectController {

    @GetMapping("/test")
    public String test() {
        String hostname = "test.test.test";
        int port = 43;

        try {
            Socket socket = new Socket(hostname, port);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            printWriter.println(hostname + ", " + port);

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("line : " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("test end");

        return "test end!!!!!!!!!!";
    }
}