package enemy;
import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;


public class Enemy extends GameObjectBase{
/**
 * コンストラクタ
 * @param x　double x座標
 * @param y double y座標
 */
	public Enemy(double x, double y) {
		super(x, y, 50, 50);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.RED);
		d.fillRect(getX(), getY(), getWidth(), getHeight());
 
	}

}
