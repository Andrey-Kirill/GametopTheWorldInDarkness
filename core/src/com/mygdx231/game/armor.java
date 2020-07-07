package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx231.game.menu.hit;

public class armor extends Game{
   public  boolean armor[] = new boolean[5]; //массив на наличие бронь в инвентаре
    public int armoronyou = 0; //номер надетой брони от одного до пяти
    MyGdxGame1 game;
    Texture ar1;//текстура брони 1
    Texture ar2;//текстура брони 2
    Texture ar3;//текстура брони 3
    Texture ar4;//текстура брони 4
    Texture ar5;//текстура брони 5
    SpriteBatch batch;
    OrthographicCamera camera;
    public armor(MyGdxGame1 game1) {
        game = game1;
    }
    @Override
    public void create() {
        for(int i = 0; i < 5; i++){
            armor[i] = false;
        }
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        ar1 = new Texture("armor1.png");
        ar2 = new Texture("armor2.png");
        ar3 = new Texture("armor4.png");
        ar4 = new Texture("armor3.png");
        ar5 = new Texture("armor5.png");
    }
    public void render() {

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        //начало отрисовки брони. Она производится если броня есть в инвентаре
        if (armor[0] == true && inventory.b == 1) {
            batch.draw(ar1, 17, 417);
        }
        if (armor[1] == true && inventory.b == 1) {
            batch.draw(ar2, 69, 417);
        }
        if (armor[2] == true && inventory.b == 1) {
            batch.draw(ar3, 120, 418);
        }
        if (armor[3] == true && inventory.b == 1) {
            batch.draw(ar4, 172, 418);
        }
        if (armor[4] == true && inventory.b == 1) {
            batch.draw(ar5, 223, 417);
        }
        if(armoronyou == 1){
            batch.draw(ar1, 381, 71);
        }else if(armoronyou == 2){
            batch.draw(ar2, 381, 71);
        }else if(armoronyou == 3){
            batch.draw(ar3, 381, 72);
        }else if(armoronyou == 4){
            batch.draw(ar4, 381, 72);
        }else if(armoronyou == 5){
            batch.draw(ar5, 381, 71);
        }
        //конец отрисовки брони
        batch.end();
        //если игрок убил зомби на втором уровне, то появляется шанс выпадения 1 и 2 брони

        if (game.randomarmor > 20 && game.randomarmor <= 70) {//если выпадет число от 21 до 70 то выпадет первая броня
            armor[0] = true;
        }
        if ((game.randomarmor2 > 0 && game.randomarmor <= 10) || (game.randomarmor > 70)) {//если выпадет число 1-10 или 71-100 то выпадает вторая броня
            armor[1] = true;
        }

        //если игрок убивает зомби на третьем уровне , то появляется шанс выпадения 3-5 бронь

        if (game.randomarmor2 > 30 && (game.randomarmor2 <= 60)) {//если выпадает число 31-60 , то выпадает 3 броня
            armor[2] = true;
        }
        if (game.randomarmor2 > 0 && game.randomarmor2 <= 20) {//если выпадает число 1-20 то выпадает 4 броня
            armor[3] = true;
        }
        if (game.randomarmor2 > 60) {//если выпадает число 61-100 то снова находится случайное число
            game.randomarmor2 = MathUtils.random(1, 100);
            if (game.randomarmor2 <= 10 || game.randomarmor2 > 90) {//если второе случайное число либо 1-10 или 91-100 то снова находится случайное число
                game.randomarmor2 = MathUtils.random(1, 100);
                if (game.randomarmor2 > 50 && game.randomarmor2 <= 60) {//если третье число 51-60 то игрок получает 5 броню
                    armor[4] = true;
                }
            }
        }

        if (Gdx.input.justTouched()) {//здесь производится выбор брони
            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.camera.unproject(game.touchPos6);
            if ((game.touchPos6.x >= 15 && game.touchPos6.x <= 65) && (game.touchPos6.y >= 412 && game.touchPos6.y <= 472)) {
                if (armor[0] == true) {
                    armoronyou = 1;
                }
            }
            if ((game.touchPos6.x >= 65 && game.touchPos6.x <= 115) && (game.touchPos6.y >= 412 && game.touchPos6.y <= 472)) {
                if (armor[1] == true) {
                    armoronyou = 2;
                }
            }
            if ((game.touchPos6.x >= 117&& game.touchPos6.x <= 167) && (game.touchPos6.y >= 412 && game.touchPos6.y <= 472)) {
                if (armor[2] == true) {
                    armoronyou = 3;
                }
            }
            if ((game.touchPos6.x >= 170 && game.touchPos6.x <= 220) && (game.touchPos6.y >= 412 && game.touchPos6.y <= 472)) {
                if (armor[3] == true) {
                    armoronyou = 4;
                }
            }
            if ((game.touchPos6.x >= 222 && game.touchPos6.x <= 272) && (game.touchPos6.y >= 412 && game.touchPos6.y <= 472)) {
                if (armor[4] == true) {
                    armoronyou = 5;
                }
            }
        }
    }

public  void armoron() {
    if (armoronyou == 1) {
        int randomdamage = MathUtils.random(1, 10);
        if (randomdamage > 2 && randomdamage <= 8) {
            game.health--;
            game.a--;
            setScreen(new hit(game));
            super.render();
        }
    } else if (armoronyou == 2) {
        int randomdamage = MathUtils.random(1, 10);
        if (randomdamage <= 3 || randomdamage > 8) {
            game.health--;
            game.a--;
            setScreen(new hit(game));
            super.render();
        }
    } else if (armoronyou == 3) {
        int randomdamage = MathUtils.random(1, 10);
        if (randomdamage == 3 || randomdamage == 7 || randomdamage == 10) {
            game.health--;
            game.a--;
            setScreen(new hit(game));
            super.render();
        }
    } else if (armoronyou == 4) {
        int randomdamage = MathUtils.random(1, 10);
        if (randomdamage == 2 || randomdamage == 8) {
            game.health--;
            game.a--;
            setScreen(new hit(game));
            super.render();
        }
    } else if (armoronyou == 5) {
        int randomdamage = MathUtils.random(1, 100);
        if (randomdamage == 96) {
            game.health--;
            game.a--;
            setScreen(new hit(game));
            super.render();
        }
    }
}

    @Override
    public void dispose() {

    }
}