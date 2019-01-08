package voipsender;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Capps
 */
public class VoIPSender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Datagram dg = new Datagram();
        dg.CreateDatagramSocket(8000);
        String str = "Joaquin";
        InetAddress ip = null;
        System.out.println(str);
        try {
            ip = InetAddress.getByName("10.161.96.38"); // Joaquin's IP 
        } catch (UnknownHostException ex) {
            System.out.println("Could not find IP. Error: " + ex);
        }
        dg.CreateDatagramPacket_send(str.getBytes(), str.length(), ip, 8000);
        dg.SendPacket();
        dg.CloseConnection();
    }
    
}
