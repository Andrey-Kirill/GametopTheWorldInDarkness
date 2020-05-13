package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx231.game.states.GameStateManager;

public class level4 extends Game {
    MyGdxGame1 game;
    OrthographicCamera camera;
    public SpriteBatch batch;
    public static final int FRAME_COLS4 = 3, FRAME_ROWS4 = 2 ;
    public static final int FRAME_COLS5 = 12, FRAME_ROWS5 = 1 ;
    public Texture torch;
    public Texture owl;

    // Objects used

     public Animation<TextureRegion> swordan;
    public  TextureRegion   curentFramesword;
    public Animation<TextureRegion> swordan2;
    public  TextureRegion   curentFramesword2;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    public float StateTime4;
    public float StateTime5;
    level4(MyGdxGame1 game){
        this.game = game;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        torch = new Texture("torch4.png");
        int index4 = 0;
        TextureRegion[][] tm4 = TextureRegion.split(torch
                , torch.getWidth() / FRAME_COLS4,
                torch.getHeight() / FRAME_ROWS4);
        TextureRegion[] walkframes4 = new TextureRegion[FRAME_COLS4 * FRAME_ROWS4];
        for(int i = 0; i < FRAME_ROWS4; i++) {
            for(int j = 0; j < FRAME_COLS4; j++)
                walkframes4[index4++] = tm4[i][j];
        }
        swordan = new Animation<TextureRegion>(0.11f, walkframes4);
        StateTime4 = 0f;
     /*
        int index5 = 0;
        TextureRegion[][] tm5 = TextureRegion.split(owl
                , owl.getWidth() / FRAME_COLS5,
                owl.getHeight() / FRAME_ROWS5);
        TextureRegion[] walkframes5 = new TextureRegion[FRAME_COLS5 * FRAME_ROWS5];
        for(int i = 0; i < FRAME_ROWS5; i++) {
            for(int j = 0; j < FRAME_COLS5; j++)
                walkframes5[index5++] = tm5[i][j];
        }
        swordan2 = new Animation<TextureRegion>(0.61f, walkframes5);
        StateTime5 = 0f;
        */

    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        StateTime4 += Gdx.graphics.getDeltaTime();

        curentFramesword = swordan.getKeyFrame(StateTime4, true);

      /*  StateTime5 += Gdx.graphics.getDeltaTime();

        curentFramesword2 = swordan2.getKeyFrame(StateTime5, true);
*/
        batch.begin();
        batch.draw(curentFramesword,417,230);


        batch.draw(game.backGround2, -10, 160);
    batch.end();
    }



    @Override
    public void dispose() {

    }
}
