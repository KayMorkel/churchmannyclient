import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ClientApp
{
    private ServerSocket server;
    private Socket serverClient;
    public static PrintWriter outClient;
    public static BufferedReader inClient;

    public ClientApp()
    {
        try{
            server = new ServerSocket( 8080);
            serverClient = server.accept();
        }
        catch(IOException ioe){
            ioe.getMessage();
        }

    }

    public void communicate(){
        try{
            outClient = new PrintWriter(serverClient.getOutputStream(), true);
            //outClient.flush();

            inClient = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
        }
        catch(IOException ioe){
            ioe.getMessage();
        }
    }

    public static void main(String[] args)
    {
        Main ren = new Main();
        ren.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ren.setBounds(700,350,930,510);
        ren.setVisible(true);
        ren.setResizable(true);
        ren.setLocationRelativeTo(null);

        ClientApp client = new ClientApp();
        client.communicate();

        System.out.println("Connected");
    }
}
