package enemy;

import java.awt.Color;
import java.util.ArrayList;

import densan.s.game.drawing.Drawer;
import Ballet.Ballet;
import Ballet.EnemyBalletManager;
import Ballet.EnemyStraightBallet;
import Ballet.PlayerBalletManager;
import Player.Player;
/**
 * ボール型の敵
 * @author tachibana
 *
 */
public class Enemy_BallType1 extends Enemy{

	private   int  HP =3;
	/**
	 * この敵の直径
	 */
	private static final int LENGTH=45;//直径であるので注意
	/**
	 * 
	 */
	private static final int DROPMONEY = 50;
	
	private ArrayList<Ballet> list = EnemyBalletManager.getInstance().getList();
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Enemy_BallType1(double x, double y) {
		super(x, y,LENGTH,LENGTH);
		// TODO 自動生成されたコンストラクター・スタブ
	
		setVector(2,Math.PI);
	}
	public void getDamage(int damage){
		HP-=damage;
		System.out.println("dameged");
		if(HP<0){
			Player.addDropmoney(DROPMONEY);
		this.remove();//aliveフラグをfalseにす
		}
	}
	
	private int time = 0;
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
		if(time> 40){
			shoot();
			time=0;
		}
		time++;
	}

	public void shoot(){
	list.add(new EnemyStraightBallet(getX(),getY()));
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.BLACK);
		d.fillCircle(this.getCenterX(), this.getCenterY(),20);
	}
	
}
