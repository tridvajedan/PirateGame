/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Korisnik
 */
public class EnemyShipController {
    private ArrayList<Ship> ships = new ArrayList<>();
    private int tickInt = 0;

    public EnemyShipController() {
    }
    public void spawnShip(Ship ship)
    {
        Random r = new Random();
        ship.setX(500);
        ship.setY(500);
        ships.add(ship);
    }
    
    
    
    public void addShip(Ship ship)
    {
        ships.add(ship);
    }

    public int getTickInt() {
        return tickInt;
    }

    public void setTickInt(int tickInt) {
        this.tickInt = tickInt;
    }
    
    
    
    public void removeShip(Ship ship)
    {
        ships.remove(ship);
    }
    
    public void tick()
    {
        tickInt++;
        Random r = new Random();
        int rand = r.nextInt(4);
        for(Ship ship : ships)
        {
            if(ship.getX() < 20 || ship.getY() < 20 || ship.getX() > GameWindow.monitor.getWidth() - 20 || ship.getY() >GameWindow.monitor.getHeight() - 20)
            {
                if(ship.getFacing() == Direction.LEFT)
                {
                    ship.setAnimInt(1 + GameWindow.enemyShip.getShipHealth() * 3);
                    ship.setX(ship.getX() + ship.getVelx());
                    ship.setFacing(Direction.RIGHT);
                }
                else if(ship.getFacing() == Direction.RIGHT)
                {
                    ship.setAnimInt(3 + GameWindow.enemyShip.getShipHealth() * 3);
                    ship.setX(ship.getX() - ship.getVelx());
                    ship.setFacing(Direction.LEFT);
                }
                else if(ship.getFacing() == Direction.UP)
                {
                    ship.setAnimInt(0 + GameWindow.enemyShip.getShipHealth() * 3);
                    ship.setY(ship.getY() - ship.getVely());
                    ship.setFacing(Direction.DOWN);
                }
                else if(ship.getFacing() == Direction.DOWN)
                {
                    ship.setAnimInt(2 + GameWindow.enemyShip.getShipHealth() * 3);
                    ship.setY(ship.getY() + ship.getVely());
                    ship.setFacing(Direction.UP);
                }
            }
            if(tickInt == 20)
        {
            tickInt = 0;
            if(rand == 1)
            {
                ship.setAnimInt(1 + GameWindow.enemyShip.getShipHealth() * 3);
                ship.setFacing(Direction.LEFT);
            }
            else if(rand == 2)
            {
                ship.setAnimInt(2 + GameWindow.enemyShip.getShipHealth() * 3);
                ship.setFacing(Direction.DOWN);
            }
            else if(rand == 3)
            {
                ship.setAnimInt(0 + GameWindow.enemyShip.getShipHealth() * 3);
                ship.setFacing(Direction.UP);
            }
            else
            {
                ship.setAnimInt(3 + GameWindow.enemyShip.getShipHealth() * 3);
                ship.setFacing(Direction.RIGHT);
            }
        }
            if(ship.getFacing() == Direction.LEFT)
           {
              ship.setX(ship.getX() - ship.getVelx());
           }
           else if(ship.getFacing() == Direction.RIGHT)
           {
              ship.setX(ship.getX() + ship.getVelx());
           }
           else if(ship.getFacing() == Direction.UP)
           {
              ship.setY(ship.getY() + ship.getVely());
           }
           else
           {
              ship.setY(ship.getY() - ship.getVely());
           }

        }
        
    }
    public void draw(Graphics g)
    {
        for(Ship ship : ships)
        {
        g.drawImage(ship.getSprites().get(ship.getAnimInt()), ship.getX(), ship.getY(), null);
    }
    }
    
    
}
