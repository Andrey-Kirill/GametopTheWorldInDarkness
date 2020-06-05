package com.mygdx231.game.sprites;




import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx231.game.MyGdxGame1;
import com.mygdx231.game.inventory;
import com.mygdx231.game.obstacles;
import com.mygdx231.game.states.PlayState;



public class Bird extends Game {
    public static final int GRAVITY = -15;
    public  static Vector3 position;
    public static Vector3 velosity;

    public MyGdxGame1 mn;

    public PlayState ps;

    public obstacles ob;
    public Bird(float x, float y,MyGdxGame1 mn,PlayState ps,obstacles ob){
        this.ps = ps;
        this.mn = mn;
        this.ob = ob;
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
    }

    public Vector3 getPosition() {
        return position;
    }
    public static  float  getPositionx() {
        return position.x;
    }
    public static float getPositiony() {
        return position.y;
    }

    public void update(float dt){
      if(mn.returnp == true || mn.health<=0){
          position.x = 5;
          position.y = 170;
      }
        if (mn.pos == true) {
            position.x = 40;
            mn.pos = false;
        } else
        if(ps.stairs == false && ob.tuy2 == false) {
            if (ob.tuy == false) {
                if (position.y >= 170)
                    velosity.add(0, GRAVITY, 0);
                velosity.scl(dt);
                position.add(0, velosity.y, 0);
                if (position.y < 170)
                    position.y = 170;
                velosity.scl(1 / dt);
            }else{
                    if (position.y >= 260)
                        velosity.add(0, GRAVITY, 0);
                    velosity.scl(dt);
                    position.add(0, velosity.y, 0);
                    if (position.y < 260)
                        position.y = 260;
                    velosity.scl(1 / dt);
            }
        }else{
            if(ps.stairs == false) {
                if (ob.tuy2 == false) {
                    if (position.y >= 170)
                        velosity.add(0, GRAVITY, 0);
                    velosity.scl(dt);
                    position.add(0, velosity.y, 0);
                    if (position.y < 170)
                        position.y = 170;
                    velosity.scl(1 / dt);
                } else {
                    if (position.y >= 337)
                        velosity.add(0, GRAVITY, 0);
                    velosity.scl(dt);
                    position.add(0, velosity.y, 0);
                    if (position.y < 337)
                        position.y = 337;
                    velosity.scl(1 / dt);
                }
            }
        }
    }
    // метод осуществляющий прыжок
    public void jump(){
        if(inventory.b4 == true) {
            velosity.y = 400;
        }else{
            velosity.y = 550;
        }

    }
    // методы управления главным персонажем
    public void right(){
        position.x += mn.speed * Gdx.graphics.getDeltaTime();
    }

    public void left(){
        position.x -= mn.speed * Gdx.graphics.getDeltaTime();
    }

    public void down(){
        position.y -= mn.speed * Gdx.graphics.getDeltaTime();
    }

    public void up(){
        position.y += mn.speed * Gdx.graphics.getDeltaTime();
    }


    @Override
    public void create() {

    }
}

