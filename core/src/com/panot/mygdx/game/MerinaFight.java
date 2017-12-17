package com.panot.mygdx.game;

import com.badlogic.gdx.Game;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MerinaFight extends Game {
	public SpriteBatch batch;
	public BitmapFont yourBitmapFontName;
//	private String yourScoreName;
	public boolean isPress = false;

	@Override
	public void create () {
		 batch = new SpriteBatch();
		 yourBitmapFontName = new BitmapFont();
	     setScreen(new GameScreen(this));

	}
	
	@Override
	public void render () {
		 super.render();
//		 yourScoreName = "score: " + GameScreen.score;

	}
	
	@Override
	public void dispose () {
        batch.dispose();
        
	}
	
	public int fight() {
		if(player() == com()) {//same element
			return 0;
		}
		else {
			if(player() == com()+1) {//win
				return 1;
			}
			else if(player() == com()+2) {//opposite element will accident
				return -1;
			}
			else if(player() == com()-1 && player() != 0){//lose
				return -1;
			}
			else{//bug
				return 0;
			}
		}
		
	}
	
	public int player() {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			isPress = true;
	        return 1;
	    }
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			isPress = true;
	        return 2;
	    }
		else if(Gdx.input.isKeyPressed(Keys.UP)) {
			isPress = true;
	        return 3;
	    }
		else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			isPress = true;
	        return 4;
	    }
		else{
			isPress = false;
			return 0;
		}
	}
	
	public int com() {
		Random random = new Random();
		int Comrandom = 1 + random.nextInt(3);
		return Comrandom;
	}
	
	public void Tenthsubclass() {//this is 10th sub class
		
	}

}
