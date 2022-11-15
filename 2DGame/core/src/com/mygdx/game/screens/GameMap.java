package com.mygdx.game.screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class GameMap {
    private TiledMap map;

    public static TiledMap getMap() {
        return new TmxMapLoader().load("maps/test.tmx");
    }
}
