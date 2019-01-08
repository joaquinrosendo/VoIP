package voipreceiver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import voipreceiver.Datagram;

/**
 *
 * @author Capps
 */
public class VoIPReceiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Datagram dg = new Datagram();
        dg.CreateDatagramSocket(8000);
        String str; 
        byte[] buff = null;
        dg.CreateDatagramPacket_rec(buff, 0);
    }
    
}
