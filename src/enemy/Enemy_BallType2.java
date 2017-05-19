package enemy;

import java.util.ArrayList;

import densan.s.game.calc.Calc;
import densan.s.game.drawing.Drawer;
import Ballet.Ballet;
import Ballet.EnemyBalletManager;
import Player.Player;

public class Enemy_BallType2 extends Enemy{

	/**
	 * この敵の直径
	 */
	private static final int LENGTH=40;//直径であるので注意
	
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
		
	}
	@Override
	public void shoot() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		
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
