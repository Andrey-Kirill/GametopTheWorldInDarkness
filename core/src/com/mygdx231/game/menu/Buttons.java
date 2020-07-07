package com.mygdx231.game.menu;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx231.game.MyGdxGame1;



public class Buttons extends Stage {
    final MyGdxGame1 game;
    Texture buttonUpImage;
    Texture buttonDownImage;
    TextButton button;
    public int health=10;
    public Buttons(final MyGdxGame1 myGdxGame){
        game = myGdxGame;

       /* buttonUpImage = new Texture("drt1.png");
        buttonDownImage = new Texture("droplet.png");

        BitmapFont font = new BitmapFont();
        Skin skin = new Skin();

        skin.add("button_up", buttonUpImage);
        skin.add("button_down", buttonDownImage);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.checked = skin.getDrawable("button_up");

        button = new TextButton("Test game", textButtonStyle);
        button.setPosition(500, 500);
        addActor(button);

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                  health=10;
            }
        });

        */
    }
}
