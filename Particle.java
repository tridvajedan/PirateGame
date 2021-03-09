/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Korisnik
 */
public class Particle {
    private int x,y;
    private int particleCounter = 0;
    private int particleSize = 20;
    private Image image;

    public Particle(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        image = ImageIO.read(new File("C://Users/Korisnik/Pictures/pirate/explosion.png"));
    }

    public int getParticleCounter() {
        return particleCounter;
    }

    public void setParticleCounter(int particleCounter) {
        this.particleCounter = particleCounter;
    }
    
    
    
    public void draw(Graphics g)
    {
        particleSize++;
        particleCounter++;
        int newx = x-(particleSize/2);
        int newy = y-(particleSize/2);
        g.drawImage(image, newx,newy, particleSize,particleSize,null);
    }
    
    
}
