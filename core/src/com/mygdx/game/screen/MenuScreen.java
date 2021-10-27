package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;
import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture img;
    //Texture imgBackground;
//    private Vector2 touch;
//    private Vector2 v;
    private Vector2 pos;
    private Texture bg;

    private Background background;
    private Logo logo;


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);

        img = new Texture("badlogic.jpg");
        logo = new Logo(img);
        //imgBackground = new Texture("background.jpg");
//        touch = new Vector2();
//        v = new Vector2(1,1);
        pos = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        //batch.draw(imgBackground,0,0,500,500);
        background.draw(batch);
        logo.draw(batch);
        //batch.draw(img, pos.x,pos.y, 0.5f, 0.5f);
        logo.update(delta);
        batch.end();



//        if (pos.dst(touch)<=v.len()){
//            pos.set(touch);
//        } else {
//            pos.add(v);
//        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
        //imgBackground.dispose();
    }

//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        touch.set(screenX, Gdx.graphics.getHeight()-screenY);
//        v.set(touch.cpy().sub(pos)).nor();
//        return super.touchDown(screenX, screenY, pointer, button);
//    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        logo.touchDown(touch,pointer,button);
        return super.touchDown(touch, pointer, button);
    }
}
