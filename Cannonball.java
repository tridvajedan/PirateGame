/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Korisnik
 */
public class Cannonball{
    Image image;
    private int x,y,velx = 15, vely = 15;
    private Direction dir = Direction.LEFT;

    public Cannonball(int x,int y,Direction dir) throws IOException {
        this.image = ImageIO.read(new File("C://Users/Korisnik/Pictures/pirate/cannonball.png"));
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDir() {
        return dir;
    }
    
    
    
    public void tick() throws InterruptedException
    {
        if(dir.equals(Direction.LEFT))
        {
            x -= velx;
        }
        else if(dir.equals(Direction.RIGHT))
        {
            x += velx;
        }
        else if(dir.equals(Direction.UP))
        {
            y += vely;
        }
        else if(dir.equals(Direction.DOWN))
        {
            y -= vely;
        }
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image,x,y,40,40,null);
    }


    
    
    
}
