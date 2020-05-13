package com.mygdx231.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx231.game.MyGdxGame1;
import java.util.Iterator;

public class Door implements Screen {
    final MyGdxGame1 game;
    SpriteBatch batch2;
    Texture gun1;
    Texture bullet;
    Rectangle bucket;
    OrthographicCamera camera;

    public Door(final MyGdxGame1 myGdxGame) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        game = myGdxGame;
        batch2 = new SpriteBatch();
        gun1  = new Texture("gunlv1.png");
        bullet = new Texture("bullet.png");
        bucket = new Rectangle();
        bucket.width = 14;
        bucket.height = 14;
        bucket.x = 490;
        bucket.y = 170;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        bucket.x -= 200 * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
