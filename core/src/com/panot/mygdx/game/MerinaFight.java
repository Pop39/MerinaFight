package com.panot.mygdx.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MerinaFight extends ApplicationAdapter {
	public SpriteBatch batch;
	Texture img;
	ImageIcon icon;
	JLabel button;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("thunder.jpg");
		icon = new ImageIcon("fire.jpg");
		button = new JLabel(icon);

	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(img, 50, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
