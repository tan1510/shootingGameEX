package enemy;

import densan.s.game.drawing.Drawer;

/**
 * エネミーを生成するクラスのインターフェース
 * @author tachibana
 *
 */
public interface StageConstoracter {

	
	public void update();
	
	public void draw(Drawer d);

}
