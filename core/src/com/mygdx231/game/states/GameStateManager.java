package com.mygdx231.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;


public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }
 // метод для постановки главного персонажа
    public void set(State state){
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

}
