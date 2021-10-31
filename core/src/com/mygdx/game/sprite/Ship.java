package com.mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.Sprite;
import com.mygdx.game.math.Rect;

public class Ship extends Sprite {

    private static final float PADDING = 0.0025f;
    public Vector2 touch = new Vector2();
    public Vector2 v = new Vector2();
    public Vector2 speed = new Vector2(0.4f,0);

    public Ship(TextureAtlas atlas) {
        super(new TextureRegion(atlas.findRegion("main_ship")),1,2,2);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setBottom(worldBounds.getBottom()+PADDING);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v,delta);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.cpy().sub(pos)).nor();
        return false;
    }

    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            v.set(speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            v.set(speed).rotateDeg(180);
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }
}
