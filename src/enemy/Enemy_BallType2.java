package enemy;

import java.awt.Color;
import java.util.ArrayList;

import densan.s.game.calc.Calc;
import densan.s.game.drawing.Drawer;
import Ballet.Ballet;
import Ballet.EnemyBalletManager;
import Ballet.EnemyStraightBallet;
import Player.Player;

public class Enemy_BallType2 extends Enemy{

	/**
	 * この敵の直径
	 */
	private static final int LENGTH=45;//直径であるので注意
	
	private int HP = 3;
	
	private ArrayList<Ballet> list = EnemyBalletManager.getInstance().getList();
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Enemy_BallType2(double x, double y) {
		super(x, y,LENGTH,LENGTH);
		// TODO 自動生成されたコンストラクター・スタブ
	
		double rad = Calc.getRadian(this, Player.getInstance());
		setVector(2,rad);
	}
	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.RED);
		d.fillCircle(this.getCenterX(), this.getCenterY(),20);
		if(time%60==0){
			shoot();
		}
		time++;
		
	}
	private int time = 0;
	private double rad  = Math.PI;
	@Override
	public void shoot() {
		// TODO 自動生成されたメソッド・スタブ
		list.add(new EnemyStraightBallet(getCenterX(),getCenterY(),rad));
		
	}
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
		
	}
	@Override
	public void getDamage(int damage) {
		// TODO 自動生成されたメソッド・スタブ
		HP-=damage;
		System.out.println("dameged");
		if(HP<0){
		this.remove();//aliveフラグをfalseにする
		
		}
		
	}
	
}
