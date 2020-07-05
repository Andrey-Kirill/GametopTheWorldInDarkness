package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
// класс для логики и отрисовки  меню паузы
public class Menu extends Game {
    final MyGdxGame1 game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture pause;
    Texture  returnbig;
    Texture  continueb;
    Texture homepage;
    Texture pause2;
    Texture instructionbutton;
    Texture instruction;
    public static Texture invexit;

    public Menu(final MyGdxGame1 myGdxGame) {
        game = myGdxGame;
    if(game.chests==true){
        game.amount = game.amount+10;
        game.chests = false;
        }
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        pause = new Texture("pause.png");
        returnbig = new Texture("returnbig.png");
        continueb = new Texture("continue.png");
        homepage = new Texture("homepage.png");
        pause2 = new Texture("pause2.png");
        instructionbutton = new Texture("instruction.png");
        instruction = new Texture("instructionforgame1.jpg");
        invexit = new Texture("invexit.png");
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(pause, 740, 420);
        batch.draw(pause, 740, 420);
        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            game.camera.unproject(game.touchPos6);
            if ((game.touchPos6.x >= 740 && game.touchPos6.x <= 790) && (game.touchPos6.y >= 420 && game.touchPos6.y <= 470) && game.instr == false) {
                if(mainmenu.options == true) {
                    game.buttons.play();
                }
                if (game.pause == 1) {
                    game.pause = 0;
                } else {
                    game.pause = 1;
                }
            }
        }
        if (game.pause == 1) {
            batch.draw(pause2,0,0);
            batch.draw(returnbig, 430, 300);
            batch.draw(continueb, 570, 300);
            batch.draw(homepage,150,300);
            batch.draw(instructionbutton,290,300);
            batch.draw(returnbig, 430, 300);
            batch.draw(continueb, 570, 300);
            batch.draw(homepage,150,300);
            batch.draw(instructionbutton,290,300);
            batch.draw(returnbig, 430, 300);
            batch.draw(continueb, 570, 300);
            batch.draw(homepage,150,300);
            batch.draw(instructionbutton,290,300);
            if (Gdx.input.justTouched()) {
                // if program caught touch on screen
                game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                game.camera.unproject(game.touchPos6);
                if ((game.touchPos6.x >= 430 && game.touchPos6.x <= 510) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380) && game.instr == false) {
                    game.returnp=true;
                    if(mainmenu.options == true) {
                        game.buttons.play();
                    }
                }
                if ((game.touchPos6.x >= 570 && game.touchPos6.x <= 650) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380) && game.instr == false) {
                    game.pause=0;
                    if(mainmenu.options == true) {
                        game.buttons.play();
                    }
                }
                if ((game.touchPos6.x >= 150 && game.touchPos6.x <= 230) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380) && game.instr == false) {
                       game.begin=true;
                       game.rand = (MathUtils.random(1, 2));
                       if(mainmenu.options == true) {
                           game.buttons.play();
                       }
                }
                if ((game.touchPos6.x >= 290 && game.touchPos6.x <= 370) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380)) {
                    game.instr = true;
                    if(mainmenu.options == true) {
                        game.buttons.play();
                    }
                }
            }
            if(game.instr==true){
                batch.draw(instruction,0,0);
                batch.draw(invexit,8,422);
                batch.draw(invexit,8,422);
                batch.draw(invexit,8,422);
                batch.draw(invexit,8,422);
                if ((game.touchPos6.x >= 9 && game.touchPos6.x <= 59) && (game.touchPos6.y >= 422 && game.touchPos6.y <= 472)) {
                    game.instr = false;
                    if(mainmenu.options == true) {
                        game.buttons.play();
                    }
                }
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        returnbig.dispose();
        continueb.dispose();
        continueb.dispose();
        homepage.dispose();
        pause2.dispose();
        instruction.dispose();
        instructionbutton.dispose();
    }
}
