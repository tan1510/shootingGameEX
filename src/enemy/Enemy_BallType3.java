package enemy;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import Ballet.Ballet;
import Ballet.EnemyBalletManager;
import Ballet.EnemyStraightBallet;
import Player.Player;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;

public class Enemy_BallType3 extends Enemy{
	
	private static final Image image = ImageLoader.load("image/baseballball.jpg");
	private static final int DROPMONEY = 70;
	private Random r = new Random();
	/**
	 * この敵の直径
	 */
	private static final int LENGTH=90;//直径であるので注意
	
	private int HP = 3;

	private int time = 0;

	/**
	 * コンストラクタ　エネミーの座標指定不可
	 */
	public Enemy_BallType3() {
		super(640, 240,  LENGTH,  LENGTH);
		// TODO Auto-generated constructor stub
		setVx(-2);
	}

	@Override
	public void draw(Drawer d) {
		// TODO Auto-generated method stub
//		d.setColor(Color.RED);
//		d.fillCircle(this.getCenterX(), this.getCenterY(),20);
		d.drawScaleImage(image, getX(), getY(), 0.04);
	
	}

	@Override
	public void getDamage(int damage) {
		// TODO Auto-generated method stub
		HP-=damage;
		System.out.println("dameged");
		if(HP<0){
			Player.addDropmoney(DROPMONEY);
		this.remove();//aliveフラグをfalseにする
		}

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		EnemyBalletManager.getInstance().balletAdd(new EnemyStraightBallet(getCenterX(),getCenterY()));
		}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		double rad =Math.sin(Math.PI/120*time+Math.PI);
		if(r.nextInt(100)==0){
			shoot();
		}
		setY(240*Math.sin(rad)+240);
		move();
		System.out.println(rad);
		time++;
	}
	

}
