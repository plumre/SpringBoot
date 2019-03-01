package com.bayee.util.proxyDP;

/*
 * Created by renhongjiang on 2018/12/5.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/5 11:18
 */
interface SocketInterface {
    String readLine();

    void writeLine(String str);

    void dispose();
}

class SocketProxy implements SocketInterface {

    // Create a wrapper for a remote
    // or expensive, sensitive target
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SocketProxy(String host, int port, boolean wait) {
        try {
            if (wait) {
                // Encapsulate the complexity/overhead of the target in the wrapper
                ServerSocket serverSocket = new ServerSocket(port);
                socket = serverSocket.accept();
            } else {
                socket = new Socket(host, port);
            }
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readLine() {
        String str = null;
        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public void writeLine(String str) {
        // the wrapper delegates to the target
        out.println(str);
    }

    @Override
    public void dispose() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        // the client deals with the wrapper
        SocketInterface socketInterface = new SocketProxy("localhost", 8080, "first".equals(args[0]));
        String str;
        boolean skip = true;
        while (true) {
            if ("second".equals(args[0]) && skip) {
                skip = !skip;
            } else {
                str = socketInterface.readLine();
                System.out.println("Receive - " + str);
                if (str == null) {
                    break;
                }
            }
            System.out.print("Send - - - ");
            str = new Scanner(System.in).nextLine();
            socketInterface.writeLine(str);
            if ("quit".equals(str)) {
                break;
            }
        }
        socketInterface.dispose();
    }

}