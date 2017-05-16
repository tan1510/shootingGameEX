package enemy;
import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;


public abstract class Enemy extends GameObjectBase{
	
/**
 * コンストラクタ
 * @param x　double x座標
 * @param y double y座標
 */
	public Enemy(double x, double y,int width,int height) {
		super(x, y, width, height);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public abstract void draw(Drawer d);
	/**
	 * hpを減らし、hpが0以下になった場合aliveフラグを消去
	 * @param damage
	 */
	public abstract void getDamage(int damage);
	/**
	 * 射撃アクション
	 * 
	 */
	public abstract void shoot();
	
	/**
	 * 攻撃力のゲッター
	 */
	//public abstract int getPower();

}
