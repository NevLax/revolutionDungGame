package ru.nlx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyMainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Dino dinozavr;
	Texture dino;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		dino = new Texture(Gdx.files.internal("dinoCharacters/sheets/DinoSprites-doux.png"));
		dinozavr = new Dino(dino);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		dinozavr.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		dino.dispose();
	}
}
