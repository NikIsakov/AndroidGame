package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AndroidGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imgBackground;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		imgBackground = new Texture("background.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0.5f, 0, 1);
		batch.begin();
		batch.draw(imgBackground,0,0,500,500);
		batch.draw(img, 500, 340,140,140);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		imgBackground.dispose();
	}
}
