package enemy;
import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;


public abstract class Enemy extends GameObjectBase{
	private int hp = 3;
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
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.RED);
		d.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	/**
	 * hpを減らし、hpが0以下になった場合aliveフラグを消去
	 * @param damage
	 */
	public void getDamage(int damage){
		hp-=damage;
		if(hp<0){
		this.remove();//aliveフラグをfalseにする
		System.out.println("dameged");
		}
	}
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
