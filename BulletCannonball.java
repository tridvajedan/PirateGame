/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Korisnik
 */
public class BulletCannonball {
    ArrayList<Cannonball> cannonballs = new ArrayList<>();
    
    public void tick() throws InterruptedException, IOException
    {
        for(int i = 0; i < cannonballs.size();i++)
        {
            Cannonball tempBall = cannonballs.get(i);
            Ship tempShip = GameWindow.enemyShip;
            Rectangle r = new Rectangle(tempBall.getX(),tempBall.getY(),tempBall.getImage().getWidth(null),tempBall.getImage().getHeight(null));
            Rectangle r2 = new Rectangle(tempShip.getX(),tempShip.getY(),tempShip.getSprites().get(tempShip.getAnimInt()).getWidth(null),tempShip.getSprites().get(tempShip.getAnimInt()).getHeight(null));
            if(r.intersects(r2))
            {
                Rectangle inter = r.intersection(r2);
                Particle particle = new Particle(inter.x,inter.y);
                GameWindow.particleController.addParticle(particle);
                cannonballs.remove(tempBall);
                GameWindow.enemyShip.setShipHealth(GameWindow.enemyShip.getShipHealth() + 1);
            }
            else
            {
            tempBall.tick();
        }
        }
    }

    public int getCannonballLength() {
        return cannonballs.size();
    }

    public ArrayList<Cannonball> getCannonballs() {
        return cannonballs;
    }

    public void setCannonballs(ArrayList<Cannonball> cannonballs) {
        this.cannonballs = cannonballs;
    }
    
    
    
    public void addBall(Cannonball ball)
    {
        cannonballs.add(ball);
    }
    public void removeBall(Cannonball ball)
    {
        cannonballs.remove(ball);
    }
    public void draw(Graphics g)
        {
            for(int i = 0; i < cannonballs.size(); i++)
            {
                Cannonball tempBall = cannonballs.get(i);
                if(tempBall.getX() < 0 || tempBall.getY() < 0 || tempBall.getX() > GameWindow.monitor.getWidth() || tempBall.getY() >GameWindow.monitor.getHeight())
                {
                    cannonballs.remove(tempBall);
                }
                tempBall.paint(g);
            }
        }    
}
