package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {

    // the movement velocity
    private Vector2 velocity = new Vector2();

    private float speed = 60 * 2, gravity = 60 * 1.8f;

    private TiledMapTileLayer collisionLayer;


    public Player(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite);

        this.collisionLayer = collisionLayer;
    }
    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    private void update(float delta) {

        int mouseX = Gdx.input.getX(), mouseY = Gdx.input.getY();

        float oldX = getX(), oldY = getY(), tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();

        //move on x
        setX(getX() + velocity.x * delta);
        boolean collisionX = false, collisionY = false;

        if(velocity.x < 0) {
            // left
            if(!collisionX)collisionX = collisionLayer.getCell((int)(getX() / tileWidth),(int)((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("hasCollision");
        } else if (velocity.x > 0) {
            // right
            if(!collisionX)collisionX = collisionLayer.getCell( (int) ((getX() + getWidth()) / tileWidth), (int)((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("hasCollision");
        }

        // react to x collision
        if(collisionX) {
            setX(oldX);
            velocity.x = 0;
        }
        //move on y
        setY(getY() + velocity.y * delta);

        if(velocity.y < 0) {
            // bot
            if(!collisionY)collisionY = collisionLayer.getCell( (int) ((getX() + getWidth() / 2) / tileWidth), (int)(getY() / tileHeight)).getTile().getProperties().containsKey("hasCollision");
        } else if (velocity.y > 0) {
            // top
            if(!collisionY)collisionY = collisionLayer.getCell( (int) ((getX() + getWidth() / 2) / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("hasCollision");
        }

        // react to y collision
        if(collisionY) {
            setY(oldY);
            velocity.y = 0;
        }
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                velocity.y = speed;
                break;
            case Input.Keys.A:
                velocity.x =  -speed;
                break;
            case Input.Keys.D:
                velocity.x = speed;
                break;
            case Input.Keys.S:
                velocity.y = -speed;
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                velocity.y = 0;
                break;
            case Input.Keys.A:
                velocity.x =  0;
                break;
            case Input.Keys.D:
                velocity.x = 0;
                break;
            case Input.Keys.S:
                velocity.y = 0;
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
