package com.cctc.amatlock.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Paddle player = Screen.getInstance().player;


        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setVelY(-1);

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setVelY(1);

        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        Paddle player = Screen.getInstance().player;

        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setVelY(0);

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setVelY(0);

        }
    }
}
