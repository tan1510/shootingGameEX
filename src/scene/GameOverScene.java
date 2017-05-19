package scene;
import densan.s.game.drawing.Drawer;
import densan.s.game.manager.Updatable;


public class GameOverScene implements Updatable{
	/**
	 * game の最後のシーンをコンストラクタから引き継いで保持するフィールド
	 */
	private  Drawer lastGameScene;
	/**
	 * 
	 * @param d
	 */

	public GameOverScene(Drawer d) {
		// TODO 自動生成されたコンストラクター・スタブ
		lastGameScene = d;
	}
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d=lastGameScene;
		
	}

}
