package Ballet;
import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;

/**
 * 弾のクラス
 * @author tachibana
 *
 */
public class StraightBallet extends GameObjectBase implements Ballet{

	/**
	 * xベクトル とりあえず初期値10
	 */
	private double xVector=10;
	/**
	 * yベクトル とりあえず初期値10に設定
	 */
	private double yVector=10; 
	/**
	 * boolean プレイヤーが放った弾であるかどうか
	 */
	private boolean playerBallet = true;
	/**
	 * 弾
	 * @param x x座標
	 * @param y y座標
	 * @param length 半径
	 * @param deg  角度
	 */
	public StraightBallet(double x, double y, double length, double deg) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(x, y, 10,10 );
		//ベクトル設定
		//xVector =length * Math.cos(Math.toRadians(deg));
	//	yVector =length * length * Math.cos(Math.toRadians(deg));
		this.setVector(length, deg);
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
	}
/**bulletの描画
 * 
 */
	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.BLACK);
		d.fillCircle(this.getX(), this.getY(),2);
	}
	
	

}
