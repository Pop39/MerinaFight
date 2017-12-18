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
        yourBitmapFontName.dispose();
        
	}
	
}
