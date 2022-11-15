package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;

public class Bullet {


    public static float getX(double ang, float hip) {
        return (float) Math.cos(ang) * hip;
    }
    public static float getY(double ang, float hip) {
        return (float) Math.sin(ang) * hip;
    }
}
