/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Korisnik
 */
public class Ship{
    private int x = 500, y = 500, velx = 10, vely = 10,width = 66,height = 113;
    private String name;
    private ArrayList<Image> sprites = new ArrayList<>();
    private boolean canFire = true;
    private int shootCooldown = 0;
    private String shipName = "";
    private String folderName = "";
    private Direction facing = Direction.DOWN;
    private int animInt = 0;
    private int shipHealth = 0; 

    public Ship(String name,String shipName,String folderName) throws IOException {
        this.name = name;
        this.folderName = folderName;
        this.shipName = shipName;
    }

    public void checkCollision(BulletCannonball controller)
    {
        for(Cannonball ball : controller.getCannonballs())
        {
            
        }
        
    }
    
    public int getAnimInt() {
        return animInt;
    }

    public void setVelx(int velx) {
        this.velx = velx;
    }

    public void setVely(int vely) {
        this.vely = vely;
    }

    
    
    public void setAnimInt(int animInt) {
        this.animInt = animInt;
    }

    
    
    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    
    
    public int getShootCooldown() {
        return shootCooldown;
    }

    public void setShootCooldown(int shootCooldown) {
        this.shootCooldown = shootCooldown;
    }

    
    
    public boolean CanFire() {
        return canFire;
    }

    public void setCanFire(boolean canFire) {
        this.canFire = canFire;
    }

    
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelx() {
        return velx;
    }

    public int getVely() {
        return vely;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Image> getSprites() {
        return sprites;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
    }

        
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(sprites.get(0), x,y,null);
    }
    
    
    public void init() throws IOException
    {
        File dir = new File("C://Users/Korisnik/Pictures/pirate/player");     
        for(int i = 0; i < dir.list().length; i++)
        {
            System.out.println("C://Users/Korisnik/Pictures/pirate/"+ folderName +"/" + shipName + " " + "(" +i + ")" + ".png");
            File file = new File("C://Users/Korisnik/Pictures/pirate/"+ folderName +"/" + shipName + " " + "(" +i + ")" + ".png");
            
            Image img = ImageIO.read(file);
            sprites.add(img);
        }
    }
}
