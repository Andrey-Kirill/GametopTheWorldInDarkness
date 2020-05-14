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
    int a = 0;
    int b = 0;
    Array<Rectangle> levels3;
    ArrayList<Rectangle> death4_1;
    long lastDropTime3;
    public  Texture deathanim;
    public Texture deathanim2;
    Rectangle death;
    public static final int FRAME_COLS4 = 3, FRAME_ROWS4 = 1 ;
    public static final int FRAME_COLS5 = 3, FRAME_ROWS5 = 1 ;
    // Objects used

    public Animation<TextureRegion> swordan;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    float StateTime4;
    public Animation<TextureRegion> swordan2;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    float StateTime5;


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

         death = new Rectangle();
         death.x = 700;
         death.y = 160;
         death.width = 23;
         death.height = 98;
        death4_1 =  new ArrayList<>();
        death4_1.add(death);


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

    }

    private void spawn3() {
        Rectangle sp3 = new Rectangle();
        sp3.y = MathUtils.random(160,160);
        sp3.x = MathUtils.random(700, 700);
        sp3.width = 28;
        sp3.height = 98;
        levels3.add(sp3);
        lastDropTime3 = TimeUtils.nanoTime();
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        StateTime4 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword = swordan.getKeyFrame(StateTime4, true);

        StateTime5 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword2 = swordan2.getKeyFrame(StateTime5, true);

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
            for (Rectangle de : death4_1) {
                batch.draw(curentFramesword2, de.x, de.y);
            }

        }

        batch.draw(game.backGround2, -10, 160);
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
                        game.health = game.health - 2;
                        game.a = game.a - 2;
                        setScreen(new hit(game));
                        super.render();
                }
                if (raindrope.overlaps(game.gun)) {
                    if(mainmenu.options == true) {
                        game.deaths.play();
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

    }

    @Override
    public void dispose() {

    }
}