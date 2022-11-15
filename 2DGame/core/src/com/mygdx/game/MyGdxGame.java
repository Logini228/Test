package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.entities.Bullet;
import com.mygdx.game.screens.Play;

public class MyGdxGame extends Game {

	ShapeRenderer shape;
    public static double rng = 0;

	@Override
	public void create() {

		setScreen(new Play());
		shape = new ShapeRenderer();
		rng = 90;//Math.random() * 360;
	}
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();

		float centerX = 1280/2, cursorX = Gdx.input.getX();
		float centerY = 720/2, cursorY = Gdx.input.getY();
/*
		float hip = (float) Math.sqrt(Math.pow(centerY - cursorY,2) + Math.pow(centerX - cursorX,2));

		float cos = (cursorX - centerX) / hip;
		float sin = ((centerY - cursorY)) / hip;
		float tan = ((centerY - cursorY) / (cursorX - centerX));

		//float circleX = ((cursorX - centerX) / 2) + centerX, circleY = ((centerY - cursorY) / 2) + centerY;
		float circleX = ((cursorX - centerX)) + centerX, circleY = (centerY - cursorY) + centerY;
*/
		//boolean xCollides =
		//boolean yCollides
		shape.begin(ShapeRenderer.ShapeType.Filled);
		for(int x = 0; x < Math.round(1000); x++) {
			float speed =  Gdx.graphics.getDeltaTime();;
			shape.circle((Bullet.getX(rng,x) + centerX), (Bullet.getY(rng,x) + centerY), 10);

		}

		//System.out.println(Bullet.getX(rng) + centerX + " " + Bullet.getY(rng) + centerY);

		shape.end();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

}
