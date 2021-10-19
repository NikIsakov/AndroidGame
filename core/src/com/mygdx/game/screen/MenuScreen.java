package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    Texture imgBackground;
    private Vector2 touch;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        imgBackground = new Texture("background.jpg");
        touch = new Vector2();
        v = new Vector2(1,1);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(imgBackground,0,0,500,500);
        batch.draw(img, 500, 340,140,140);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        imgBackground.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight()-screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
