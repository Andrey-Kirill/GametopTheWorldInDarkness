package com.mygdx231.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx231.game.MyGdxGame1;

import com.mygdx231.game.obstacles;
import com.mygdx231.game.sprites.Bird;


public class PlayState extends State {

    private Bird bird;

    final MyGdxGame1 mn;

    public static boolean stairs;
    public obstacles ob;

    public PlayState(GameStateManager gsm ,MyGdxGame1 mn,obstacles ob) {
        super(gsm);
        this.mn = mn;
        this.ob = ob;
        bird = new Bird(mn.x,mn.y,mn,this,ob);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            mn.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            mn.camera.unproject(mn.touchPos6);

            if ((mn.touchPos6.x >= 560 && mn.touchPos6.x <= 600) && (mn.touchPos6.y >= 100 && mn.touchPos6.y <= 140) && mn.pause == 0 && mn.r == true) {

                if (mn.y <= 170) {
                    bird.jump();
                }
                if (Bird.position.y == 260) {
                    if (mn.y <= 260) {
                        bird.jump();
                    } else {

                    }
                }
                if(Bird.position.y == 337){
                    if (mn.y <= 337) {
                        bird.jump();
                    } else {

                    }
                }
            }
        }
        if (Gdx.input.isTouched()) {
            // if program caught touch on screen
            mn.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            mn.camera.unproject(mn.touchPos6);
            if ((mn.touchPos6.x >= 60 && mn.touchPos6.x <= 110) && (mn.touchPos6.y >= 70 && mn.touchPos6.y <= 120) && mn.pause == 0 && mn.r == true) {
                bird.left();
            }
            if ((mn.touchPos6.x >= 155 && mn.touchPos6.x <= 205) && (mn.touchPos6.y >= 70 && mn.touchPos6.y <= 120) && mn.pause == 0 && mn.r == true) {
                bird.right();
            }
        }


        if (mn.npc.width == 0) {
            if (mn.backGround == mn.backGround3) {
                if (mn.stairs4.overlaps(mn.bucket)) {
                    stairs = true;
                    mn.batch.draw(mn.down, 560, 40);

                    if (Gdx.input.isTouched()) {
                        mn.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0);// считываем положение касания
                        mn.camera.unproject(mn.touchPos6);

                            if ((mn.touchPos6.x >= 560 && mn.touchPos6.x <= 600) && (mn.touchPos6.y >= 105 && mn.touchPos6.y <= 145) && Bird.position.y < 580 ) {  // если оно зафиксирвано  зоне кнопки входа то меняем фон на фон 4 уровня
                                bird.up();
                            }

                        if ((mn.touchPos6.x >= 560 && mn.touchPos6.x <= 600) && (mn.touchPos6.y >= 40 && mn.touchPos6.y <= 80) && Bird.position.y >= 170) {  // если оно зафиксирвано  зоне кнопки входа то меняем фон на фон 4 уровня
                            bird.down();
                        }
                    }

                }else{
                    stairs= false;
                }
            }
        }
    }


    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        mn.x = bird.getPosition().x;
        mn.y = bird.getPosition().y;
    }


}
