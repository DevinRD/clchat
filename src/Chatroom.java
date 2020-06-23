import java.net.ServerSocket;
import java.net.Socket;

import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Chatroom extends Thread {
    // options
    // fields: name of room
    // whitelist/blacklist, connections limit, 
    // private/public

    private String name;

    private ArrayList<String> whitelist;
    private ArrayList<String> blacklist;

    private boolean isPublic;

    private ServerSocket serverSocket;
    private ArrayList<Socket> peers;
    private ArrayList<PrintWriter> peersOut;
    private ArrayList<BufferedReader> peersIn;

    private int port;

    public Chatroom() throws IOException {
        name = "default";
        whitelist = new ArrayList<String>();
        blacklist = new ArrayList<String>();
        isPublic = false;
        port = 1998;
        serverSocket = new ServerSocket(port);
        peers = new ArrayList<Socket>();
        peersOut = new ArrayList<PrintWriter>();
        peersIn = new ArrayList<BufferedReader>();
    }

    public Chatroom(String name) throws IOException {
        this.name = name;
        whitelist = new ArrayList<String>();
        blacklist = new ArrayList<String>();
        isPublic = false;
        port = 1998;
        serverSocket = new ServerSocket(port);
        peers = new ArrayList<Socket>();
        peersIn = new ArrayList<BufferedReader>();
    }

    private class ChatIn extends Thread {

        private BufferedReader socketIn;

        public ChatIn(BufferedReader in) {
            socketIn = in;
        }

        public void run() {
            String input = "";
            
            try {
                while (input != null) {
                    input = socketIn.readLine();
                    System.out.println("            " + input);
                }
            } catch (IOException e) {
                System.out.println("Trouble reading message from peer");
            }

        }
    }

    private class ChatOut extends Thread {

        private Scanner sysIn;

        public ChatOut() {
            sysIn = new Scanner(System.in);
        }

        public void run() {
            String input = "";

            while (true) {
                System.out.print("");
                input = sysIn.nextLine();
                for (int i = 0; i < peersOut.size(); i++) peersOut.get(i).println(input);
            }
        }
    }

    public void start() {
        new ChatOut().start();

        while (true) {
            try {
                peers.add(serverSocket.accept());
                peersOut.add(new PrintWriter(peers.get(peers.size() - 1).getOutputStream(), true));
                peersIn.add(new BufferedReader(new InputStreamReader(peers.get(peers.size() - 1).getInputStream())));
                new ChatIn(peersIn.get(peersIn.size() - 1)).start();
            } catch (IOException e) {
                System.out.println("Connection failed");
            }
        }
    }

    public void close() {
        try {
            for (PrintWriter p: peersOut) p.close();
            for (BufferedReader b: peersIn) b.close();
            for (Socket s: peers) s.close();
        } catch (IOException e) {
            System.out.println("Connection close warning");
        }

    }

}