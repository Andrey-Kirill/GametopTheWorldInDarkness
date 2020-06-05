package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
// класс для логики и отрисовки главниго меню
public class mainmenu extends Game {

    final MyGdxGame1 game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture begin1;
    Texture begin2;
    public boolean loading;
    public static boolean options = true;
    public static boolean options2;
    public int b = 1;
    public  static  Texture on;
    public  static  Texture off;
    public mainmenu(MyGdxGame1 game) {
        this.game = game;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        begin1 = new Texture("begin3.jpg");
        begin2 = new Texture("begin2.jpg");
        on = new Texture("on.png");
        off = new Texture("off.png");
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if(game.rand==1) {
            batch.draw(begin1, 0, 0);
        }
        if(game.rand==2){
            batch.draw(begin2,0,0);
        }

        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            game.camera.unproject(game.touchPos6);
            if ((game.touchPos6.x >= 536 && game.touchPos6.x <= 718) && (game.touchPos6.y >= 349 && game.touchPos6.y <= 440) && options2 == false) {
                if(options == true) {
                    game.buttons.play();
                }
                loading=true;
                game.sps4 = false;
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        game.begin = false;
                        game.pause = 0;
                        loading=false;
                        game.sps4 = true;
                    }
                }, 3);
            }
            if ((game.touchPos6.x >= 536 && game.touchPos6.x <= 718) && (game.touchPos6.y >= 91 && game.touchPos6.y <= 182) && options2 == false) {
                game.exit=true;
                if(options == true) {
                    game.buttons.play();
                }
            }
            if((game.touchPos6.x >=536  && game.touchPos6.x <= 718) && (game.touchPos6.y >= 220 && game.touchPos6.y <= 311)){
                if(options == true) {
                    game.buttons.play();
                }
                options2 = true;
            }
            if((game.touchPos6.x >= 9  && game.touchPos6.x <= 59) && (game.touchPos6.y >= 422 && game.touchPos6.y <= 472)){
                if(options == true){
                    game.buttons.play();
               }
                options2 = false;
            }
            if ((game.touchPos6.x >= 246 && game.touchPos6.x <= 318) && (game.touchPos6.y >= 363 && game.touchPos6.y <= 413) && options2 == true) {
                if (b == 1) {
                    b = 0;
                } else
                    b = 1;
            }
        }
        if(loading==true){
            game.nxt.render();
        }
        batch.end();
        if(b == 1){
            options = true;
        }
        if(b == 0){
            options = false;
        }
    }

    @Override
    public void dispose(){
        batch.dispose();
        begin1.dispose();
        begin2.dispose();
    }
}