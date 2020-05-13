package com.mygdx231.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx231.game.MyGdxGame1;

public class Level0 implements Screen {

    final MyGdxGame1 game;
    OrthographicCamera camera;
    SpriteBatch batch1;
    Buttons buttons;
    Texture dropImage;
    Texture bucketImage;
    Texture gameover;
    Texture restart;
    Texture gameover1;

    public Level0(final MyGdxGame1 myGdxGame) {

        game = myGdxGame;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        buttons = new Buttons(game);
        Gdx.input.setInputProcessor(buttons);
        batch1 = new SpriteBatch();

        restart = new Texture("return.png");
        gameover = new Texture("gameover.png");
        gameover1 = new Texture("gameover1.jpg");
    }

    private void createBackground() {    }

    @Override
    public void show() {    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch1.setProjectionMatrix(camera.combined);
        batch1.begin();
        batch1.draw(gameover,0, 0);
        batch1.draw(gameover1,200, 260);
        batch1.draw(restart,380, 170);
        batch1.end();
    }

    @Override
    public void resize(int width, int height) {    }

    @Override
    public void pause() {    }

    @Override
    public void resume() {    }

    @Override
    public void hide() {    }

    @Override
    public void dispose() {
        batch1.dispose();
        dropImage.dispose();
        bucketImage.dispose();
        gameover.dispose();
        restart.dispose();
        gameover1.dispose();
    }
}
