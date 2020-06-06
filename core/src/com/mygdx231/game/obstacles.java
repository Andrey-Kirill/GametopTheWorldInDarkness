package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx231.game.menu.hit;
import java.util.Iterator;

public class obstacles extends Game {

    final MyGdxGame1 game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Texture obstacle1;
    Texture obstacle11;
    public static Texture chestinv;
    Texture eye;
    public static Texture chestarr;
    public Rectangle ob1;
    public Rectangle ob2;
    public boolean tuy = false;
    public boolean tuy2 = false;
    Texture chestanim;
    Texture chestopen;
    public static Texture bow;
    public int b = 0;
    BitmapFont FontRed1;
    public String arrows;
    public int arr = 10;
    Array<Rectangle> levels3;
    long lastDropTime3;


    public static final int FRAME_COLS4 = 4, FRAME_ROWS4 = 1 ;

    // Objects used

    public Animation <TextureRegion> swordan;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    float StateTime4;


    public obstacles(final MyGdxGame1 myGdxGame) {
        game = myGdxGame;

    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        obstacle1 = new Texture("tier2.jpg");
        obstacle11 = new Texture("tier1.1.png");
        chestanim = new Texture("chestopen.png");
        eye = new Texture("eyeball.png");
        chestopen = new Texture("chestopen2.png");
        chestinv = new Texture("chestinv.png");
        chestarr = new Texture("chestarr.png");
        bow = new Texture("icon3.png");
        FontRed1 = new BitmapFont(Gdx.files.internal("arial-15.fnt"));
        FontRed1.setColor(Color.WHITE);
        ob1 = new Rectangle();
        ob1.x = 240;
        ob1.y = 260;
        ob1.width = obstacle1.getWidth() - 30;
        ob1.height = obstacle1.getHeight();
        ob2 = new Rectangle();
        ob2.x = 500;
        ob2.y = 337;
        ob2.width = obstacle1.getWidth() - 30;
        ob2.height = obstacle1.getHeight();

        levels3 = new Array<Rectangle>();
        spawn3();

        // анимация для меча в правую сторону

        int index4 = 0;
        TextureRegion[][] tm4 = TextureRegion.split(eye
                , eye.getWidth() / FRAME_COLS4,
                eye.getHeight() / FRAME_ROWS4);
        TextureRegion[] walkframes4 = new TextureRegion[FRAME_COLS4 * FRAME_ROWS4];
        for(int i = 0; i < FRAME_ROWS4; i++) {
            for(int j = 0; j < FRAME_COLS4; j++)
                walkframes4[index4++] = tm4[i][j];
        }
        swordan = new Animation<TextureRegion>(0.11f, walkframes4);
        StateTime4 = 0f;

        // анимация для меча в левую сторону;

    }
    private void spawn3() {
        Rectangle sp3 = new Rectangle();
        sp3.y = MathUtils.random(260, 400);
        sp3.x = MathUtils.random(800, 800);
        sp3.width = 28;
        sp3.height = 28;
        levels3.add(sp3);
        lastDropTime3 = TimeUtils.nanoTime();
    }
    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        StateTime4 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword = swordan.getKeyFrame(StateTime4, true);


        arrows =  Integer.toString(arr);
        if (game.y > 250 && game.bucket.overlaps(ob1)) {
            tuy = true;
        } else {
            tuy = false;
        }
        if (game.turn == false && game.x <= 206) {
            tuy = false;
        }

        if (game.y > 327 && game.bucket.overlaps(ob2) && tuy == false) {
            tuy2 = true;
        } else {
            tuy2 = false;
        }
        if (game.turn == false && game.x <= 456 && tuy == false) {
            tuy2 = false;
        }
        if (tuy2 == true) {
            if (Gdx.input.justTouched()) {
                // if program caught touch on screen
                game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                game.camera.unproject(game.touchPos6);

                if ((game.touchPos6.x >= 534 && game.touchPos6.x <= 577) && (game.touchPos6.y >= 342 && game.touchPos6.y <= 385) && game.pause == 0 && inventory.k2>0) {
                    inventory.k2--;
                    if (b == 1) {
                        b = 0;
                    } else
                        b = 1;
                }
            }
        }
        if (b == 1) {
            batch.draw(chestopen, 534, 342);
            if(tuy2 == true) {
                batch.draw(chestinv, 297, 351);
                if(game.chest == true){
                    batch.draw(chestarr, 303, 358);
                    FontRed1.draw(batch, arrows, 327, 371);
                }
                if(game.chest2 == true){
                    batch.draw(bow, 370, 415);
                }
                if (Gdx.input.justTouched()) {
                    // if program caught touch on screen
                    game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                    game.camera.unproject(game.touchPos6);

                    if ((game.touchPos6.x >= 297 && game.touchPos6.x <= 349) && (game.touchPos6.y >= 351 && game.touchPos6.y <= 410) && game.pause == 0 && game.chest == true) {
                          game.chest = false;
                          game.amount += 10;
                    }
                    if ((game.touchPos6.x >= 349 && game.touchPos6.x <= 401) && (game.touchPos6.y >= 416 && game.touchPos6.y <= 474) && game.pause == 0 && game.chest2 == true) {
                        game.chest2 = false;
                    }
                }
            }

        } else {
            batch.draw(chestanim, 534, 342);
        }
        batch.draw(obstacle1, ob1.x, ob1.y);
        batch.draw(obstacle1, ob2.x, ob2.y);
        batch.draw(obstacle11, 240, 267);
        batch.draw(obstacle11, 500, 344);
        for (Rectangle sp3 : levels3) {
            batch.draw(curentFramesword, sp3.x, sp3.y);
        }

        batch.end();
        // летающие противники для 2 уровня
        if((game.instr==false && game.pause == 0) && game.r==true) {

                if (TimeUtils.nanoTime() - lastDropTime3 > (MathUtils.random(1000000000, 1000000000))) {
                    spawn3();
                }
            Iterator<Rectangle> iter3 = levels3.iterator();
            while (iter3.hasNext()) {
                Rectangle raindrope = iter3.next();
                if (game.pause == 0) {
                    game.pausep = true;
                }
                if (game.r == true) {
                    if (game.pausep == true) {
                        raindrope.x -= (MathUtils.random(150,150)) * Gdx.graphics.getDeltaTime();
                    }
                }
                if (game.pause == 1) {
                    game.pausep = false;
                }
                if (game.r == false) {
                    if (game.pausep == false) {
                        raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
                    }
                }
                if (raindrope.overlaps(game.bucket)) {
                    if (game.shieldh == 0) {
                        if(mainmenu.options == true) {
                            game.touch.play();
                        }
                        if(game.ar.armoronyou == 1 || game.ar.armoronyou == 2 || game.ar.armoronyou == 3 || game.ar.armoronyou == 4 || game.ar.armoronyou == 5) {
                            game.ar.armoron();
                        }else {
                            game.health--;
                            game.a--;
                            setScreen(new hit(game));
                            super.render();
                        }
                    } else {
                        game.shieldh--;
                    }
                }
                if (raindrope.overlaps(game.gun)) {
                    if(mainmenu.options == true) {
                        game.deaths.play();
                    }
                    int potion2 = MathUtils.random(1, 5);
                    if (potion2 == 5) {
                        if (game.shield < 5) {
                            game.shield++;
                        }
                    }
                    game.coins = game.coins + 1;
                }
                if (game.bulletrec.overlaps(raindrope)) {
                    if(mainmenu.options == true) {
                        game.deaths.play();
                    }
                    game.kill = true;
                    game.coins = game.coins + 1;
                }

                if (game.backGround != game.level2 || game.npc.width != 0 || game.sps == 0 || raindrope.overlaps(game.gun) || raindrope.overlaps(game.bucket) || raindrope.x <= 0 || game.begin == true || raindrope.overlaps(game.bulletrec)) {
                    iter3.remove();
                }
            }
        }
    }

    @Override
    public void dispose() {
       obstacle1.dispose();
       obstacle11.dispose();
       chestinv.dispose();
       chestarr.dispose();
       chestanim.dispose();
       chestopen.dispose();
       bow.dispose();
    }
}