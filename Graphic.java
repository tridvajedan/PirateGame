/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Korisnik
 */
public class Graphic extends JPanel implements ActionListener{
    private Timer t = new Timer(0,this);
    private Image background;
    public int direction = 0;

    public Graphic() throws IOException {
        this.background = ImageIO.read(new File("C://Users/Korisnik/Pictures/sea.jpg"));
        GameWindow.ship.init();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background,0,0,(int)GameWindow.monitor.getWidth(),(int)GameWindow.monitor.getHeight(),this);
        GameWindow.shipController.draw(g);
        for(int i = 0; i < GameWindow.controller.getCannonballLength(); i++)
        {
            GameWindow.controller.draw(g);
        }
        for(int i = 0; i < GameWindow.particleController.getParticlesLength();i++)
        {
            GameWindow.particleController.draw(g);
        }
        g2.drawImage(GameWindow.ship.getSprites().get(direction),GameWindow.ship.getX(),GameWindow.ship.getY(),this);
        t.start();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    
    
}
