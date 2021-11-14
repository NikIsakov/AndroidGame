package com.mygdx.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.base.BaseButton;
import com.mygdx.game.math.Rect;
import com.mygdx.game.screen.GameScreen;

public class NewGameButton extends BaseButton {
    private GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setTop(-0.012f);
    }
}
