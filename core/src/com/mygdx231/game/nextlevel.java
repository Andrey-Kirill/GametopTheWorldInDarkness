package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class nextlevel extends Game {
    final MyGdxGame1 game;
    Texture nextlevelpicture;
    Texture black;
    SpriteBatch batch;
    OrthographicCamera camera;
    private static final int FRAME_COLS = 3, FRAME_ROWS = 1;
    private static final int FRAME_COLS2 = 3, FRAME_ROWS2 = 1;
    private static final int FRAME_COLS3 = 3, FRAME_ROWS3 = 1;

    Animation<TextureRegion> walkAnimation;
    Animation <TextureRegion> zombieWalk;
    Animation <TextureRegion> zombie3;

    float stateTime;
    float StateTime2;
    float StateTime3;

    Texture walkSheet;
    Texture zombielvl3;
    Texture zombie;

    public nextlevel(final MyGdxGame1 myGdxGame) { game = myGdxGame; }

    @Override
    public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        nextlevelpicture = new Texture("loading.png");
        black = new Texture("gameover.png");
        zombie = new Texture("zombie2.png");
        zombielvl3 = new Texture("zombie3.png");

        walkSheet = new Texture(Gdx.files.internal("zombie1.1.png"));
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / FRAME_COLS,
                walkSheet.getHeight() / FRAME_ROWS);
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS *
                FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
        stateTime = 0f;

        int index2 = 0;
        TextureRegion[][] tm2 = TextureRegion.split(zombie,
                zombie.getWidth() / FRAME_COLS2,
                zombie.getHeight() / FRAME_ROWS2);
        TextureRegion[] walkframes2 = new TextureRegion[FRAME_COLS2 * FRAME_ROWS2];
        for(int i = 0; i < FRAME_ROWS2; i++) {
            for(int j = 0; j < FRAME_COLS2; j++)
                walkframes2[index2++] = tm2[i][j];
        }
        zombieWalk = new Animation<TextureRegion>(0.25f, walkframes2);
        StateTime2 = 0f;

        int index3 = 0;
        TextureRegion[][] tm3 = TextureRegion.split(zombielvl3
                , zombielvl3.getWidth() / FRAME_COLS3,
                zombielvl3.getHeight() / FRAME_ROWS3);
        TextureRegion[] walkframes3 = new TextureRegion[FRAME_COLS3 * FRAME_ROWS3];
        for(int i = 0; i < FRAME_ROWS3; i++) {
            for(int j = 0; j < FRAME_COLS3; j++)
                walkframes3[index3++] = tm3[i][j];
        }
        zombie3 = new Animation<TextureRegion>(0.25f, walkframes3);
        StateTime3 = 0f;
    }
    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        StateTime2 += Gdx.graphics.getDeltaTime();
        StateTime3 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramezombie = zombieWalk.getKeyFrame(StateTime2, true);
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        TextureRegion curentFramezombielvl3 = zombie3.getKeyFrame(StateTime3, true);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(black, 0, 0);
        batch.draw(nextlevelpicture, 310, 110);
        batch.draw(currentFrame,325, 220);
        batch.draw(curentFramezombie, 385, 220);
        batch.draw(curentFramezombielvl3,445,220);
        batch.end();
    }
}
