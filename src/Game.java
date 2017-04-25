import Ballet.BalletManager;
import densan.s.game.drawing.Drawer;
import densan.s.game.manager.Updatable;
import enemy.Enemy;
import enemy.EnemyManager;

/**
 * シーンinGameでの処理
 * @author tachibana
 *
 */
public class Game implements Updatable {
/**
 * プレイヤーオブジェクト
 */
	private Player player;
	/**
	 * balletManagerのフィールド
	 */
	private BalletManager balletManager;
	/**
	 * EnemyManagerのフィールド
	 */
	private EnemyManager enemyManager;
	/**
	 * コンストラクタ
	 */
	public Game(){
		player= new Player();
		balletManager = BalletManager.getInstance();
		enemyManager = EnemyManager.getInstance(); 
		enemyManager.addEnemy(new Enemy(300,300));
	}
	
	
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		player.update();
		balletManager.update();
		enemyManager.update();
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		player.draw(d);
		balletManager.draw(d);
		enemyManager.draw(d);
	}

}
