package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class items extends Game {
    Texture inventorybar;
    Texture icontop;
    SpriteBatch batch;
    OrthographicCamera camera;
    final inventory gameinv;


    public items(final inventory myGdxGame) {
        gameinv = myGdxGame;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        icontop = new Texture("icontop.png");
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(inventorybar, 270, 60);
        batch.draw(icontop, 486, 87);
        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            gameinv.touchPos7.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            gameinv.camera.unproject(gameinv.touchPos7);

            if ((gameinv.touchPos7.x >= 10 && gameinv.touchPos7.x <= 60) && (gameinv.touchPos7.y >= 288 && gameinv.touchPos7.y <= 348)) {

            }

            batch.end();

        }
    }
}

