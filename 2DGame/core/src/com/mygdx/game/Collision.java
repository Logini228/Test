package com.mygdx.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.screens.GameMap;

public class Collision {
    private TiledMap map = GameMap.getMap();

    private TiledMapTileLayer colLayer = (TiledMapTileLayer) map.getLayers().get(0);

    public boolean collidesX(float x, float y) {
        x = Math.round(x/16);
        y = Math.round(y/16);

        boolean collX = colLayer.getCell((int) x, (int) y).getTile().getProperties().containsKey("hasCollision");
        if(collX == true){
            return true;
        } else {
            return false;
        }

    }

    public boolean collidesY(float x, float y) {
        x = Math.round(x / 16);
        y = Math.round(y / 16);

        boolean collY = colLayer.getCell((int) x, (int) y).getTile().getProperties().containsKey("hasCollision");
        if (collY == true) {
            return true;
        } else {
            return false;
        }

    }
}
