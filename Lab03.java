import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
public class Lab03{
    public static void main(String [] args){
        JFrame window = new JFrame("Ping Pong");
        window.setSize(600,500);       
        window.setVisible(true);    
        PingPong mypanel = new PingPong ();
        window.addKeyListener(mypanel);
        window.add(mypanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}