package com.cctc.amatlock.test;

import java.awt.*;

public class Ball extends CoreObject
{

    /**
     * Creates the core object. All subclasses
     * will call this with super.
     * The super call to the Rectangle class.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Ball(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void tick()
    {
        Paddle player = Screen.getInstance().player;
        Paddle computer = Screen.getInstance().computer;
        if(intersects(player) || intersects(computer))
        {
            this.setVelX( this.getVelX() * -1);

        }

        if(y < 0 || y > Reference. HEIGHT)
        {
            this.setVelY( this.getVelY() * -1);
        }

        if(x < 0)
        {
            computer.score++;
            reset();
        }
        if(x > Reference.WIDTH)
        {
            player.score++;
            reset();
        }
        y += velY;
        x += velX;
    }
    private void reset()
    {
        x = Reference.CENTER_X;
        y = Reference.CENTER_Y;

        this.setVelX(this.getVelX() * 1.3);
        double rand = Randomizer.nextDouble(-0.9, -1.1);
        this.setVelY(this.getVelY() * rand);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height );
    }
}
