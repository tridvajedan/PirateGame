/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Korisnik
 */
public class GameWindow {
    public static Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
    public static Ship ship;
    public static Ship enemyShip;
    public static Direction dir = Direction.LEFT;
    public static BulletCannonball controller = new BulletCannonball();
    public static EnemyShipController shipController = new EnemyShipController();
    public static ParticleController particleController = new ParticleController();
    
    public static void main(String[] args) throws IOException
    {
        ship = new Ship("Jackdaw","ship","player");
        enemyShip = new Ship("Enemy","ship","enemyShip");
        enemyShip.init();
        enemyShip.setVelx(5);
        enemyShip.setVely(5);
        shipController.spawnShip(enemyShip);
        
        Thread backgroundMusic = new Thread(new Runnable()
        {
            public void run()
            {
                try {
                    SoundManager.playSound("C://Users/Korisnik/Pictures/pirate/music.wav");
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                while(true)
                {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(ship.getShootCooldown() == 200)
                    {
                        ship.setCanFire(true);
                    }
                    else
                    {
                        ship.setShootCooldown(ship.getShootCooldown() + 1);
                    }
                    try {
                        controller.tick();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    shipController.tick();
            }
            }
        });
        thread.start();
        backgroundMusic.start();
        Graphic graph = new Graphic();
        JFrame f = new JFrame();
        f.setSize((int)monitor.getWidth(),(int)monitor.getHeight());
        f.add(graph);
        f.setVisible(true);
        f.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    if(ship.CanFire())
                    {
                    ship.setCanFire(false);
                    ship.setShootCooldown(0);
                        try {
                            SoundManager.playSound("C://Users/Korisnik/Pictures/pirate/cannon.wav");
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    Cannonball ball = null;                                              
                        try {
                        ball = new Cannonball(ship.getX() + ship.getWidth() /2,ship.getY() + ship.getHeight()/2,dir);
                    } catch (IOException ex) {
                        Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    controller.addBall(ball);
                    }
                }
                else if(e.getKeyChar() == 'a')
                {    
                    
                    ship.setX(ship.getX() - ship.getVelx());
                    graph.direction = 1;
                    dir = Direction.UP;
                }
                else if(e.getKeyChar() == 'w')
                {
                     
                    ship.setY(ship.getY() - ship.getVely());
                    graph.direction = 2;
                    dir = Direction.RIGHT;
                }
                else if(e.getKeyChar() == 's')
                {
                     
                    ship.setY(ship.getY() + ship.getVely());
                    graph.direction = 0;
                    dir = Direction.LEFT;
                }
                else if(e.getKeyChar() == 'd')
                {
                     
                    ship.setX(ship.getX() + ship.getVelx());
                    graph.direction = 3;
                    dir = Direction.DOWN;
                }
            }
            public void keyTyped(KeyEvent e)
            {
                
            }
            public void keyReleased(KeyEvent e)
            {
            }
        });
        
        
    }
    
}
