package com.panot.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {

	private MerinaFight merinaFight;
	private Texture thunderImg;
	private Texture fireImg;
	private Texture waterImg;
	private Texture leafImg;
	private Texture merin1Img;
	private Texture merin2Img;
	private Texture winP;
	private Texture winC;
	private Texture loseP;
	private Texture loseC;
	private Texture drawP;
	private Texture drawC;
	private long time;
	private String yourScoreName;
	private String set;
	public int Pcard ;
	public int Ccard;
	public int scoreP = 0;
	public int scoreC = 0;


    
	public GameScreen(MerinaFight merinaFight) {
        this.merinaFight = merinaFight;
        thunderImg = new Texture("thunder.png");
        fireImg = new Texture("fire.png");
        waterImg = new Texture("water.png");
        leafImg = new Texture("leaf.png");
        merin1Img = new Texture("merin1.png");
        merin2Img = new Texture("merin2.png");
        winP = new Texture("win2.png");
        winC = new Texture("win1.png");
        loseP = new Texture("lose2.png");
        loseC = new Texture("lose1.png");
        drawP = new Texture("draw2.png");
        drawC = new Texture("draw1.png");
    }
    
    @Override
	public void render (float delta) {
        SpriteBatch batch = merinaFight.batch;
        BitmapFont yourBitmapFontName = merinaFight.yourBitmapFontName;
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        yourScoreName = "score: " + scoreP + ":" + scoreC;
        set = "Keyboard: Left = leaf , Right = fire , Up = water , Down = thunder";
        update(delta);
        batch.begin();
        if(Pcard == 1) {
        	batch.draw(leafImg, 300,300);
        }
        else if(Pcard == 2) {
        	batch.draw(fireImg, 300,300);
        }
        else if(Pcard == 3) {
        	batch.draw(waterImg, 300,300);
        }
        else if(Pcard == 4) {
        	batch.draw(thunderImg, 300,300);
        }
        if(Ccard == 1) {
        	batch.draw(leafImg, 500,300);
        }
        else if(Ccard == 2) {
        	batch.draw(fireImg, 500,300);
        }
        else if(Ccard == 3) {
        	batch.draw(waterImg, 500,300);
        }
        else if(Ccard == 4) {
        	batch.draw(thunderImg, 500,300);
        }
        if(Pcard == Ccard && Pcard != 0 && Ccard!= 0) {//same element
			batch.draw(drawP, 0,300);
			batch.draw(drawC, 800,300);
		}
		else {
			if(Pcard == Ccard+1) {//win
				batch.draw(winP, 0,300);
				batch.draw(loseC, 800,300);
			}
			else if(Pcard == 1 && Ccard == 4) {//win
				batch.draw(winP, 0,300);
				batch.draw(loseC, 800,300);
			}
			else if(Pcard == Ccard+2) {//opposite element will accident
				batch.draw(loseP, 0,300);
				batch.draw(loseC, 800,300);
			}
			else if(Pcard == Ccard-2 && Pcard>2) {//opposite element will accident
				batch.draw(loseP, 0,300);
				batch.draw(loseC, 800,300);
			}
			else if(Pcard == Ccard-1){//lose
				batch.draw(loseP, 0,300);
				batch.draw(winC, 800,300);
			}
			else if(Pcard == 4 && Ccard == 1){//lose
				batch.draw(loseP, 0,300);
				batch.draw(winC, 800,300);
			}
		}
        yourBitmapFontName.draw(batch,set, 10, 680);
        batch.draw(leafImg, 100, 50);
        batch.draw(fireImg, 300, 50);
        batch.draw(waterImg, 500, 50);
        batch.draw(thunderImg, 700, 50);
        batch.draw(merin1Img, 100, 300);
        batch.draw(merin2Img, 700, 300);
        yourBitmapFontName.draw(batch, yourScoreName, 450, 600);
        batch.end();
    }
    
    public void update(float delta) {
        time = System.currentTimeMillis();
    	if(player() == true) {
    		com();
    		fight();
    		while(System.currentTimeMillis() < time+400) {
    			;
    		}
    	}
    }
    
	public void fight() {
		if(Pcard == Ccard) {//same element
			scoreP += 0;
			scoreC += 0;
		}
		else {
			if(Pcard == Ccard+1) {//win
				scoreP += 1;
				scoreC += -1;
			}
			else if(Pcard == 1 && Ccard == 4) {//win
				scoreP += 1;
				scoreC += -1;
			}
			else if(Pcard == Ccard+2) {//opposite element will accident
				scoreP += -1;
				scoreC += -1;
			}
			else if(Pcard == Ccard-2 && Pcard>2) {//opposite element will accident
				scoreP += -1;
				scoreC += -1;
			}
			else if(Pcard == Ccard-1 && Pcard != 1){//lose
				scoreP += -1;
				scoreC += 1;
			}
			else if(Pcard == 4 && Ccard == 1){//lose
				scoreP += -1;
				scoreC += 1;
			}
			else{//bug
				scoreP += 0;
				scoreC += 0;
			}
		}
		
	}
	
	public boolean player() {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			Pcard = 1;
	        return true;//leaf
	    }
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			Pcard = 2;
	        return true;//fire
	    }
		else if(Gdx.input.isKeyPressed(Keys.UP)) {
			Pcard = 3;
	        return true;//water
	    }
		else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			Pcard = 4;
	        return true;//thunder
	    }
		else{
			return false;
		}
	}
	
	public void com() {
		Random random = new Random();
		int Comrandom = 1 + random.nextInt(3);
		Ccard = Comrandom;
	}

    
}