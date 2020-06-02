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
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx231.game.menu.hit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class level4main extends Game {
    MyGdxGame1 game;
    OrthographicCamera camera;
    SpriteBatch batch;
    public Texture mainenemy1;
    public  Texture mainenemy2;
    Rectangle en;
    ArrayList<Rectangle> ena = new ArrayList<>();
    float delay = 6;
    BitmapFont FontRed1;
    Texture text3;
    Texture rc;
    Texture shield;
    Texture fireball;
    Texture bossheart;
    int b = 0;
    Array<Rectangle> levels3;
    ArrayList<Rectangle> death4_1;
    Array<Rectangle> raindrops;
    long lastDropTime3;
    long lastDropTime;
    public  Texture deathanim;
    public Texture deathanim2;
    public Texture death4_2;
    Rectangle death;
    ArrayList<Texture> a = new ArrayList<>();
    public boolean fireballb = false;
    public boolean over = false;
    float x = 120;
    float y = 400;
    int i = 0;
    public static final int FRAME_COLS4 = 3, FRAME_ROWS4 = 1 ;
    public static final int FRAME_COLS5 = 3, FRAME_ROWS5 = 1 ;
    public static final int FRAME_COLS6 = 1, FRAME_ROWS6 = 2 ;
    public static final int FRAME_COLS7 = 3, FRAME_ROWS7 = 1 ;
    public static final int FRAME_COLS8 = 3, FRAME_ROWS8 = 1 ;
    // Objects used

    public Animation<TextureRegion> swordan;
    public Animation<TextureRegion> swordan3;
    public Animation<TextureRegion> swordan4;
    public Animation<TextureRegion> swordan5;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    float StateTime4;
    public Animation<TextureRegion> swordan2;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    float StateTime5;
    float StateTime6;
    float StateTime7;
    float StateTime8;

    level4main(MyGdxGame1 game){
        this.game = game;
    }
    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        mainenemy1 = new Texture("mainenemy1.png");
        mainenemy2 = new Texture("mainenemy2.png");
        deathanim = new Texture("death4.png");
        deathanim2 = new Texture("death4.1.png");
        shield = new Texture("shield.png");
        fireball = new Texture("fireball.png");
        death4_2 = new Texture("death4.2.png");
        bossheart = new Texture("bossheart.png");
        rc = mainenemy1;
        en = new Rectangle();
        en.x = 700;
        en.y = 155;
        en.height = mainenemy1.getHeight();
        en.width = mainenemy1.getWidth();
        ena.add(en);
        FontRed1 = new BitmapFont(Gdx.files.internal("arial-15.fnt"));
        FontRed1.setColor(Color.WHITE);
        text3 = new Texture("text3.png");

        levels3 = new Array<Rectangle>();
        spawn3();

        a.add(shield);
        death = new Rectangle();
        death.x = 700;
        death.y = 160;
        death.width = 23;
        death.height = 98;
        death4_1 =  new ArrayList<>();
        death4_1.add(death);

        raindrops = new Array<>();


        int index4 = 0;
        TextureRegion[][] tm4 = TextureRegion.split(deathanim
                ,  deathanim .getWidth() / FRAME_COLS4,
                deathanim .getHeight() / FRAME_ROWS4);
        TextureRegion[] walkframes4 = new TextureRegion[FRAME_COLS4 * FRAME_ROWS4];
        for(int i = 0; i < FRAME_ROWS4; i++) {
            for(int j = 0; j < FRAME_COLS4; j++)
                walkframes4[index4++] = tm4[i][j];
        }
        swordan = new Animation<TextureRegion>(0.40f, walkframes4);
        StateTime4 = 0f;


        int index5 = 0;
        TextureRegion[][] tm5 = TextureRegion.split(deathanim2
                ,  deathanim2 .getWidth() / FRAME_COLS5,
                deathanim2 .getHeight() / FRAME_ROWS5);
        TextureRegion[] walkframes5 = new TextureRegion[FRAME_COLS5 * FRAME_ROWS5];
        for(int i = 0; i < FRAME_ROWS5; i++) {
            for(int j = 0; j < FRAME_COLS5; j++)
                walkframes5[index5++] = tm5[i][j];
        }
        swordan2 = new Animation<TextureRegion>(0.40f, walkframes5);
        StateTime5 = 0f;

        int index6 = 0;
        TextureRegion[][] tm6 = TextureRegion.split(fireball
                ,  fireball .getWidth() / FRAME_COLS6,
                fireball .getHeight() / FRAME_ROWS6);
        TextureRegion[] walkframes6 = new TextureRegion[FRAME_COLS6 * FRAME_ROWS6];
        for(int i = 0; i < FRAME_ROWS6; i++) {
            for(int j = 0; j < FRAME_COLS6; j++)
                walkframes6[index6++] = tm6[i][j];
        }
        swordan3 = new Animation<TextureRegion>(0.21f, walkframes6);
        StateTime6 = 0f;

        int index7 = 0;
        TextureRegion[][] tm7 = TextureRegion.split(death4_2
                ,  death4_2.getWidth() / FRAME_COLS7,
                death4_2.getHeight() / FRAME_ROWS7);
        TextureRegion[] walkframes7 = new TextureRegion[FRAME_COLS7 * FRAME_ROWS7];
        for(int i = 0; i < FRAME_ROWS7; i++) {
            for(int j = 0; j < FRAME_COLS7; j++)
                walkframes7[index7++] = tm7[i][j];
        }
        swordan4 = new Animation<TextureRegion>(0.21f, walkframes7);
        StateTime7 = 0f;

        int index8 = 0;
        TextureRegion[][] tm8 = TextureRegion.split(deathanim2
                ,  deathanim2.getWidth() / FRAME_COLS8,
                deathanim2.getHeight() / FRAME_ROWS8);
        TextureRegion[] walkframes8 = new TextureRegion[FRAME_COLS8 * FRAME_ROWS8];
        for(int i = 0; i < FRAME_ROWS8; i++) {
            for(int j = 0; j < FRAME_COLS8; j++)
                walkframes8[index8++] = tm8[i][j];
        }
        swordan5 = new Animation<TextureRegion>(0.21f, walkframes8);
        StateTime8 = 0f;

    }

    private void spawn3() {
        Rectangle sp3 = new Rectangle();
        sp3.y = MathUtils.random(160,160);
        sp3.x = MathUtils.random(660, 660);
        sp3.width = 28;
        sp3.height = 98;
        levels3.add(sp3);
        lastDropTime3 = TimeUtils.nanoTime();
    }

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.y = MathUtils.random(500, 500);
        raindrop.x = MathUtils.random(20, 780);
        raindrop.width = 25;
        raindrop.height = 64;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        StateTime4 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword = swordan.getKeyFrame(StateTime4, true);

        StateTime5 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword2 = swordan2.getKeyFrame(StateTime5, true);

        StateTime6 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword3 = swordan3.getKeyFrame(StateTime6,true);

        StateTime7 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword7 = swordan4.getKeyFrame(StateTime7,true);

        StateTime8 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword8 = swordan5.getKeyFrame(StateTime8,true);

        batch.begin();

            for (Rectangle er : ena) {
                batch.draw(mainenemy1, er.x, er.y);
            }

        if(mainenemy1 == rc){
            batch.draw(text3, 310, 405);
            FontRed1.draw(batch, "You disturb me,you will never leave alive", 322, 454);
            FontRed1.draw(batch, "I will kill you", 322, 434);
        }
        Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
            @Override
            public void run() {
              mainenemy1 = mainenemy2;

            }
        }, delay);
        if(game.bucket.overlaps(en)){
            game.health--;
        }
        if(mainenemy1 == mainenemy2 ) {
            for (Rectangle sp3 : levels3) {
                batch.draw(curentFramesword, sp3.x, sp3.y);
            }
        }

        if(b>=10) {
            if (death.x <= 500) {
                curentFramesword2 = curentFramesword7;
                Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
                    @Override
                    public void run() {
                        fireballb = true;
                    }
                }, 15);
            }
            if(fireballb == false) {
                for (Rectangle de : death4_1) {
                    batch.draw(curentFramesword2, de.x, de.y);
                }
            }
            if (curentFramesword2 != curentFramesword7) {
                for (Texture a : a) {
                    batch.draw(a, death.x - 8, death.y - 1);
                }
            } else {
                for (Texture r : a) {
                    batch.draw(r, death.x - 2, death.y - 1);
                }
            }
            if (death.x > 500) {
                death.x -= 100 * Gdx.graphics.getDeltaTime();
            }
        }
          if(fireballb == true){
              if(game.gun.overlaps(death)){
                  death4_1.remove(death);
                  death.height = 0;
                  death.width = 0;
              }if(game.bucket.overlaps(death)){
                  game.health--;
                  game.a--;
              }
              for (Rectangle de : death4_1) {
                  batch.draw(curentFramesword8, de.x, de.y);
              }
              if(game.backGround == game.level4){
                  death.x -= 50 * Gdx.graphics.getDeltaTime();
              }
          }
        batch.draw(game.backGround2, -10, 160);

        for (Rectangle raindrop : raindrops) {
            batch.draw(curentFramesword3, raindrop.x, raindrop.y);  // Draw current frame at (50, 50)
        }

        batch.end();




        if((game.instr==false && game.pause == 0) && game.r==true && mainenemy1 == mainenemy2 && game.backGround == game.level4) {

            if (TimeUtils.nanoTime() - lastDropTime3 > (MathUtils.random(1000000000, 1000000000)) && b<11) {
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

                }
                if (raindrope.overlaps(game.gun)) {
                    if(mainmenu.options == true) {
                        game.deaths.play();
                    }
                    int i = MathUtils.random(1, 5);;
                    if(i == 5){
                        inventory.velosity++;
                    }
                    b++;
                    game.coins = game.coins + 1;
                }
                if (game.bulletrec.overlaps(raindrope)) {
                    if(mainmenu.options == true) {
                        game.deaths.play();
                    }
                    game.kill = true;
                    game.coins = game.coins + 1;
                    b++;
                }
                if (game.backGround != game.level4 || game.npc.width != 0 || game.sps == 0 || raindrope.overlaps(game.gun) || raindrope.overlaps(game.bucket) || raindrope.x <= 0 || game.begin == true || raindrope.overlaps(game.bulletrec) || mainenemy1 != mainenemy2 || game.backGround != game.level4) {
                    iter3.remove();
                }
            }
        }



        if((game.instr==false && game.pause == 0) &&  game.r==true && b>=10 && curentFramesword2 == curentFramesword7) {

                if (TimeUtils.nanoTime() - lastDropTime > (MathUtils.random(100000000, 1000000000)) && fireballb == false) {
                    spawnRaindrop();
                }

            Iterator<Rectangle> iter = raindrops.iterator();
            while (iter.hasNext()) {
                Rectangle raindrope = iter.next();
                if (game.pause == 0) {
                    game.pausep = true;
                }
                if (game.r == true) {
                    if (game.pausep == true) {
                        raindrope.y -= (MathUtils.random(160,160))* Gdx.graphics.getDeltaTime();
                    }
                }
                if (game.pause == 1) {
                    game.pausep = false;
                }
                if (game.r == false) {
                    if (game.pausep == false) {
                        raindrope.y -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
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
                if (game.death == 0 || game.sps2 == 0 || raindrope.overlaps(game.bucket) || raindrope.x <= 0 || game.begin == true || game.health <= 0 || raindrope.y < -70 ) {
                    iter.remove();
                }
            }
        }
        if(fireballb == true){
            a.remove(shield);

        }
    }

    @Override
    public void dispose() {

    }
}