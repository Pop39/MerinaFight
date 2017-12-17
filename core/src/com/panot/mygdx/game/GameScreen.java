package com.panot.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {

	private MerinaFight merinaFight;
	private Texture thunderImg;
	private Texture fireImg;
	private Texture waterImg;
	private Texture leafImg;
	private Texture merin1Img;
	private Texture merin2Img;
	private long time;
	public int score = 0;
    
	public GameScreen(MerinaFight merinaFight) {
        this.merinaFight = merinaFight;
        thunderImg = new Texture("thunder.png");
        fireImg = new Texture("fire.png");
        waterImg = new Texture("water.png");
        leafImg = new Texture("leaf.png");
        merin1Img = new Texture("merin1.png");
        merin2Img = new Texture("merin2.png");
    }
    
    @Override
	public void render (float delta) {
        SpriteBatch batch = merinaFight.batch;
        batch.begin();
        batch.draw(thunderImg, 100, 50);
        batch.draw(fireImg, 300, 50);
        batch.draw(waterImg, 500, 50);
        batch.draw(leafImg, 700, 50);
        batch.draw(merin1Img, 200, 300);
        batch.draw(merin2Img, 600, 300);
        batch.end();
        update(delta);
    }
    
    public void update(float delta) {
    	score += merinaFight.fight();
        time = System.currentTimeMillis();

    	if(merinaFight.isPress == true) {//how to make a delay?
    		System.out.println("score" + score);//how to create score board ?
    		merinaFight.isPress = false;
    		while(System.currentTimeMillis() < time+800) {
    			;
    		}
    	}

    }
}