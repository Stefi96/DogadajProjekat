package main;

import forme.FormaServer;
import java.net.ServerSocket;
import niti.ServerNit;

public class Server {

    ServerSocket ss;
    ServerNit sn;

    public static void main(String[] args) {
        Server server = new Server();
        FormaServer fs = new FormaServer();
        fs.setVisible(true);
    }

    public Server() {
    }

}
