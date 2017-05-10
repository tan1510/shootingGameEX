package enemy;

import java.awt.Color;
import java.util.ArrayList;

import densan.s.game.drawing.Drawer;
import Ballet.Ballet;
import Ballet.EnemyBalletManager;
import Ballet.EnemyHomingBallet;
import Ballet.PlayerBalletManager;

public class Enemy_BallType1 extends Enemy{
/**
 * 
 */
	private ArrayList<Ballet> list = EnemyBalletManager.getInstance().getList();
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Enemy_BallType1(double x, double y) {
		super(x, y,20,20);
		// TODO 自動生成されたコンストラクター・スタブ
		setVector(2,Math.PI);
	}
	
	private int time = 0;
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
		if(time== 15){
			shoot();
		time=0;
		}
	}

	public void shoot(){
		
	list.add(new EnemyHomingBallet(getX(),getY()));
		
		
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.BLACK);
		d.fillCircle(this.getCenterX(), this.getCenterY(),20);
	}
	
}
