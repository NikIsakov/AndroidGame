package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;
import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.ExitButton;
import com.mygdx.game.sprite.Logo;
import com.mygdx.game.sprite.PlayButton;
import com.mygdx.game.sprite.Star;

public class MenuScreen extends BaseScreen {

    private static final int STAR_COUNT = 256;

    private final Game game;

    private Texture img;
    //Texture imgBackground;
//    private Vector2 touch;
//    private Vector2 v;
    private Vector2 pos;

    private TextureAtlas atlas;
    private Texture bg;

    private Background background;
    private Star[] stars;

    private ExitButton exitButton;
    private PlayButton playButton;

    //private Logo logo;

    public MenuScreen(Game game) {
        this.game = game;
    }


    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        exitButton = new ExitButton(atlas);
        playButton = new PlayButton(atlas, game);

        img = new Texture("badlogic.jpg");
        //logo = new Logo(img);
        //imgBackground = new Texture("background.jpg");
//        touch = new Vector2();
//        v = new Vector2(1,1);
        pos = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        exitButton.resize(worldBounds);
        playButton.resize(worldBounds);
        //logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //logo.update(delta);
        update(delta);
        draw();

    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
        //imgBackground.dispose();
        atlas.dispose();
    }

//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        touch.set(screenX, Gdx.graphics.getHeight()-screenY);
//        v.set(touch.cpy().sub(pos)).nor();
//        return super.touchDown(screenX, screenY, pointer, button);
//    }

//    @Override
//    public boolean touchDown(Vector2 touch, int pointer, int button) {
//        pos.set(touch);
//        logo.touchDown(touch,pointer,button);
//        return super.touchDown(touch, pointer, button);
//    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exitButton.touchDown(touch, pointer, button);
        playButton.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exitButton.touchUp(touch, pointer, button);
        playButton.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        //logo.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        exitButton.draw(batch);
        playButton.draw(batch);
        batch.end();
    }
}
