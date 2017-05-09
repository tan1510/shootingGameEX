package Ballet;

import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;
/**
 * 弾のインターフェース
 * @author tachibana
 *
 */
public abstract class Ballet extends GameObjectBase{
	
	public Ballet(double x,double y,int height,int width){
		super(x,y,height,width);
	}
	/**
	 * オーバーライド
	 * @param d
	 */
	public abstract void draw(Drawer d);
/**
 * ゲッター x座標
 * @return
 */
//	public abstract abstract double getX();
/**
 * getta- y座標
 * @return
 */
	//public abstract double getY();
/**
 * ゲームオブジェクトとしてオーバーライドするべき1fpsごとの処理
 */
	public abstract void update();
	/**
	 *ゲッター
	 * @return　　弾の威力
	 */
	public abstract int getPower();
	
}
