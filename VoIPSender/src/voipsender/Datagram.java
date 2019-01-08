package voipsender;

import java.io.IOException;
import java.net.*; // for Datagram Java Classes
import java.util.*; // for Exceptions

/*
 * @author Camron Capps
 * This program is used to send UDP packets. It acts as the server.
 * For the first iteration of this program, only ASCII will be sent/received. 
 * At a later time once this code is fully functional alongside the vocal
 * recording program, both will be tied together into one sending just clips of 
 * voice-grade audio. Then, will be threaded in order to provide real-time
 * delivery of voice-grade audio. 
 */


public class Datagram {
      DatagramSocket socket; // Used to make the connection-less socket for receiving/sending datagrams
      DatagramPacket data; // The actual UDP packet. 
      
      public void CreateDatagramSocket() // Will automatically detect an open port. 
      {
          try { 
              socket = new DatagramSocket();
          } catch (SocketException ex) {
              System.out.println("Could not establish connection. Error: " + ex);
          }
      }
      
      public void CreateDatagramSocket(int port) // attempts to bind socket to given port number
      {
          try {
              socket = new DatagramSocket(port);
          } catch (SocketException ex) {
              System.out.println("Could not establish connection. Error: " + ex);
          }
      }
      
      public void CreateDatagramPacket_send(byte[] buf,int length, InetAddress ip, int port) // used to send Datagram Packets. (I DON'T THINK LENGTH IS NEEDED)
      {
          data = new DatagramPacket(buf, length, ip, port);
      }
      
      public void DatagramPacket_UpdateData(byte[] buf)
      {
          data.setData(buf);
      }
      
      public void CreateDatagramPacket_rec(byte[] buf, int length) // used to receive Datagram Packets. 
      {
          data = new DatagramPacket(buf, length);
      }
      
      public void ReceivePacket()
      {
          try {
              socket.receive(data); // attempt to receive data
          } catch (IOException ex) {
              System.out.println("No data to receive. Error: " + ex); // print out error
              return;
          }
          
          System.out.println("Datagram packet data: " + data.getData().toString()); // print out data
      }
      
      public void SendPacket()
      {
          try {
              socket.send(data);
              System.out.println("Data sent: " + data.getData().toString());
          } catch (IOException ex) {
              System.out.println("Could not send data. Error: " + ex);
          }
      }
      
      public void CloseConnection()
      {
          socket.close();
      }
 }
   

