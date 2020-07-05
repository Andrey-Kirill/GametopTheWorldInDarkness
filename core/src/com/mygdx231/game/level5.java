package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx231.game.sprites.Bird;

public class level5 extends Game {
    MyGdxGame1 game;
    OrthographicCamera camera;
    SpriteBatch batch;
    public Texture door;
    public Texture mana;
    public Texture inside;
    public Texture light;
    public Texture trader;
    public Texture buttonbuy;
    Rectangle doorr;
    public Rectangle doorinside;
    public Rectangle traderr;
    public boolean buy = false;
    int b = 0;
    level5(MyGdxGame1 game){
        this.game = game;
    }
    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        door = new Texture("doorv.png");
        mana = new Texture("star.png");
        inside = new Texture("insidehouse.jpg");
        light = new Texture("lightinside.png");
        trader = new Texture("trader.png");
        buttonbuy = new Texture("buybutton.png");
        doorr = new Rectangle();
        doorr.width = door.getWidth();
        doorr.height = door.getHeight();
        doorr.x = 516;
        doorr.y = 183;
        doorinside = new Rectangle();
        doorinside.x = 60;
        doorinside.y = 170;
        doorinside.width = 60;
        doorinside.height = 110;
        traderr = new Rectangle();
        traderr.height = trader.getHeight();
        traderr.width = trader.getWidth();
        traderr.x = 600;
        traderr.y = 168;
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if(game.backGround == game.village) {
            if (game.bucket.overlaps(doorr)) {
                batch.draw(game.enter, 575, 35);
                if (Gdx.input.justTouched()) { // if program caught touch on screen
                    game.touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                    camera.unproject(game.touchPos1);
                    if ((game.touchPos1.x >= 575 && game.touchPos1.x <= 626) && (game.touchPos1.y >= 35 && game.touchPos1.y <= 97)) {
                        Bird.position.x = 50;
                        game.backGround = inside;
                    }
                }
            }
        }
        if(game.backGround == inside){
            if (game.bucket.overlaps(doorinside)) {
                batch.draw(game.enter, 575, 30);
                if (Gdx.input.justTouched()) { // if program caught touch on screen
                    game.touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                    camera.unproject(game.touchPos1);
                    if ((game.touchPos1.x >= 575 && game.touchPos1.x <= 626) && (game.touchPos1.y >= 30 && game.touchPos1.y <= 92)) {
                        game.backGround = game.village;
                    }
                }
            }
        }
        if(game.backGround == inside) {
            batch.draw(light, 500, 180);
            batch.draw(trader,traderr.x,traderr.y);
            if(game.bucket.overlaps(traderr)){
                if(inventory.b == 1) {
                    batch.draw(buttonbuy, 297, 295);
                    batch.draw(buttonbuy, 297, 295);
                }
                if(b == 0) {
                    batch.draw(game.text, 365, 405);
                    if(mainmenu.language == false){
                        MyGdxGame1.FontRed1.draw(batch, "You almost killed death but do not chill out", 372, 455);
                        MyGdxGame1.FontRed1.draw(batch, "She can back at anytime but you can buy something", 372, 433);
                    }else{
                        MyGdxGame1.FontRed1.draw(batch, "Ты почти победил смерть,но не расслабляйся", 372, 455);
                        MyGdxGame1.FontRed1.draw(batch, "Она может вернуться,а пока можешь закупиться", 372, 433);
                    }
                    }if (Gdx.input.justTouched()) {
                    // if program caught touch on screen
                    game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                    game.camera.unproject(game.touchPos6);

                    if ((game.touchPos6.x >= 297 && game.touchPos6.x <= 347) && (game.touchPos6.y >= 295 && game.touchPos6.y <= 360) && game.pause == 0) {
                        if (b == 1) {
                            b = 0;
                        } else
                            b = 1;
                    }
                }
                if(b == 1) {
                    batch.draw(obstacles.chestinv, 297, 351);
                    batch.draw(obstacles.chestarr, 303, 358);
                    batch.draw(inventory.potionhelth, 362, 416.5F);
                    batch.draw(inventory.potionj, 357.5F, 357);
                    batch.draw(inventory.potionshield,310,417);
                    if (Gdx.input.justTouched()) {
                        // if program caught touch on screen
                        game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                        game.camera.unproject(game.touchPos6);
                        if ((game.touchPos6.x >= 297 && game.touchPos6.x <= 349) && (game.touchPos6.y >= 351 && game.touchPos6.y <= 410) && game.pause == 0 && game.coins>=1) {
                            game.coins--;
                            game.amount++;
                        }
                        if ((game.touchPos6.x >= 349 && game.touchPos6.x <= 401) && (game.touchPos6.y >= 416 && game.touchPos6.y <= 474) && game.pause == 0 && game.coins>=2 && game.potionh <5) {
                            game.coins -= 2;
                            game.potionh++;
                        }
                        if((game.touchPos6.x >= 297 && game.touchPos6.x <= 349) && (game.touchPos6.y >= 416 && game.touchPos6.y <= 474) && game.pause == 0 && game.coins>=5 && game.shield<5){
                            game.coins -= 5;
                            game.shield++;
                        }
                        if((game.touchPos6.x >= 349 && game.touchPos6.x <= 401) && (game.touchPos6.y >= 351 && game.touchPos6.y <= 410) && game.pause == 0 && game.coins>=10 && inventory.velosity <5){
                            game.coins -= 10;
                            inventory.velosity++;
                        }
                    }
                }
            }
        }
        batch.draw(game.backGround2, -10, 160);
        batch.end();
    }

    @Override
    public void dispose() {
      door.dispose();
      mana.dispose();
      inside.dispose();
      light.dispose();
      trader.dispose();
      buttonbuy.dispose();
    }
}