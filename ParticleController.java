/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class ParticleController {
    private ArrayList<Particle> particles = new ArrayList<>();
    
    public void addParticle(Particle particle)
    {
        particles.add(particle);
    }
    public void removeParticle(Particle particle)
    {
        particles.remove(particle);
    }

    public int getParticlesLength() {
        return particles.size();
    }
    
    
    
    public void draw(Graphics g)
    {
        for(Particle particle : particles)
        {
            if(particle.getParticleCounter() == 30)
            {
                particles.remove(particle);
            }
            else
            {
                particle.draw(g);
            }
        }
    }
    
}
