package Ballet;

import java.awt.Color;

import Player.Player;
import densan.s.game.calc.Calc;
import densan.s.game.drawing.Drawer;

/**
 * オブジェクト方向時点での発射位置とプレイヤー間のベクトルを持つ弾
 * @author tachibana
 *
 */
public class EnemyHomingBallet extends Ballet {

	
	/**
	 * オブジェクトの半径
	 */
	private static final int RENGE = 2;
	/**
	 * 弾の速度
	 */
	private static final int SPEED = 5;
/**
 * 
 * @param x
 * @param y
 */
	public EnemyHomingBallet(double x, double y) {
		super(x,y,RENGE,RENGE);
		// TODO 自動生成されたコンストラクター・スタブ
		double rad= Calc.getRadian(this,Player.getInstance());
		this.setVector(SPEED, rad);
	}

	
	public EnemyHomingBallet(double x,double y,double rad) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(x,y,RENGE,RENGE);
		this.setVector(SPEED,rad);
	}
	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.BLUE);
		d.fillCircle(this.getX(), this.getY(),RENGE);
		
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
	}

	@Override
	public int getPower() {
		// TODO 自動生成されたメソッド・スタブ
		return 1;
	}

}
