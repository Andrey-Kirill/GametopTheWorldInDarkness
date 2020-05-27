package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;
import com.mygdx231.game.menu.hit;

import java.util.ArrayList;

public class obstacles3 extends Game {
    MyGdxGame1 game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Texture chestopen;
    Texture chestclose;
    Rectangle chestclose1;
    BitmapFont FontRed1;
    Texture eyet;
    public boolean poisoned = true;
    public static Texture warning;
    int b = 0;
    ArrayList<Rectangle> r = new ArrayList<>();
    private static final int FRAME_COLS4 = 4, FRAME_ROWS4 = 1;
    Rectangle eyer;
    boolean e = false;
    boolean i = false;
    Texture bucketImagepoisonright;
    Texture bucketImagepoisonleft;

    // Objects used

    Animation<TextureRegion> eye;

    // Must declare frame type (TextureRegion)
    // A variable for tracking elapsed time for the animation

    float StateTime4;

    obstacles3(MyGdxGame1 mn) {
        this.game = mn;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        chestopen = new Texture("chest3open.png");
        chestclose = new Texture("chest3close.png");
        eyet = new Texture("eyeball.png");
        warning = new Texture("thirdlevel.png");
        bucketImagepoisonright = new Texture("knightrightpoison.png");
        bucketImagepoisonleft = new Texture( "knightleftpoison.png");

        eyer = new Rectangle();
        eyer.x = 260;
        eyer.y = 202;

        r.add(eyer);

        eyer.width = 10;
        eyer.height = 10;

        chestclose1 = new Rectangle();
        chestclose1.width = chestclose.getWidth();
        chestclose1.height = chestclose.getHeight();
        chestclose1.x = 230;
        chestclose1.y = 170;
        int index4 = 0;
        TextureRegion[][] tm4 = TextureRegion.split(eyet
                , eyet.getWidth() / FRAME_COLS4,
                eyet.getHeight() / FRAME_ROWS4);
        TextureRegion[] walkframes4 = new TextureRegion[FRAME_COLS4 * FRAME_ROWS4];
        for (int i = 0; i < FRAME_ROWS4; i++) {
            for (int j = 0; j < FRAME_COLS4; j++)
                walkframes4[index4++] = tm4[i][j];
        }
        eye = new Animation<TextureRegion>(0.11f, walkframes4);
        StateTime4 = 0f;
        // анимация для меча в левую сторону;
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        StateTime4 += Gdx.graphics.getDeltaTime();

        TextureRegion curentFramesword = eye.getKeyFrame(StateTime4, true);
        batch.begin();

        if (game.bucket.overlaps(chestclose1)) {
            if (Gdx.input.justTouched()) {
                // if program caught touch on screen
                game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                game.camera.unproject(game.touchPos6);

                if ((game.touchPos6.x >= 230 && game.touchPos6.x <= 273) && (game.touchPos6.y >= 173 && game.touchPos6.y <= 216) && game.pause == 0 && inventory.k1 > 0) {
                    inventory.k1--;
                    if (b == 1) {
                        b = 0;
                    } else
                        b = 1;
                }
            }
        }
        if (b == 1) {
            e = true;
            batch.draw(chestopen, chestclose1.x, chestclose1.y);
        }
        if (b == 0) {
            batch.draw(chestclose, chestclose1.x, chestclose1.y);
        }
        batch.draw(game.backGround2, -10, 160);
        if (e == true) {
            for (Rectangle rc : r) {
                batch.draw(curentFramesword, rc.x, rc.y);
            }
        }
        if (game.backGround == game.backGround3 && e == true) {
            eyer.x -= 150 * Gdx.graphics.getDeltaTime();
        }
        if (e == true) {
            if (game.bucket.overlaps(eyer)) {
                if (game.shieldh == 0) {
                    if (mainmenu.options == true) {
                        game.touch.play();
                    }
                    game.health = game.health - 1;
                    game.a = game.a - 1;
                    setScreen(new hit(game));
                    super.render();
                } else {
                    game.shieldh--;
                }
            }
        }
        if (eyer.x < 0 || game.bucket.overlaps(eyer) || eyer.overlaps(game.gun)) {
            r.remove(eyer);
            eyer.width = -1000;
            eyer.height = -1000;
        }
        if (game.bucket.x > 200 && game.bucket.x < 642 && poisoned == true) {
            poisoned = false;
            game.a--;
            game.health--;
            Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
                @Override
                public void run() {
                    poisoned = true;
                }
            }, 3);
        }
        if (game.bucket.x > 200 && game.bucket.x < 642){
            game.bucketImage = bucketImagepoisonright;
            game.characterleft = bucketImagepoisonleft;
        }else{
            game.characterleft = game.l3;
            game.bucketImage = game.r3;
        }
        batch.end();
    }
    @Override
    public void dispose() {
        chestclose.dispose();
        chestopen.dispose();
    }
}