import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import Ballet.EnemyBalletManager;
import Ballet.PlayerBalletManager;
import Player.Player;
import densan.s.game.drawing.Drawer;
import densan.s.game.manager.Updatable;
import enemy.Enemy;
import enemy.StageConstoracter;
import enemy.EnemyGeneretor1;
//import enemy.EnemyGeneretorByTime;
import enemy.EnemyManager;

/**
 * シーン<br>
 * inGameでの処理
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
	private PlayerBalletManager balletManager_p;
	/**
	 * 
	 */
	private EnemyBalletManager balletManager_e;
	/**
	 * EnemyManagerのフィールド
	 */
	private EnemyManager enemyManager;
	/**
	 * エネミーを経過時間に応じて生成するクラスのインスタンス
	 */
	//private EnemyGeneretorByTime generater;
	/**
	 * エネミージェネレーター
	 */
	private StageConstoracter eg;
	/**
	 * ステージナンバーを保持
	 */
	private int stageNum=1;
	/**
	 * BGMプレイヤー
	 */
	private BGM bgm;
	
	/**
	 * コンストラクタ
	 */
	public Game(){
		player=Player.getInstance();
		balletManager_p = PlayerBalletManager.getInstance();
		balletManager_e = EnemyBalletManager.getInstance();
		enemyManager = EnemyManager.getInstance();
		switch(stageNum){
			case 1:
		eg = new EnemyGeneretor1();
		//未実装
		/*
		bgm = new BGM();
		bgm.play();
		*/
			default:
				System.err.println("ステージ未選択");
		}
		/*
		try {
			generater = EnemyGeneretorByTime.getInstance();
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		*/
	}
	
	private int t = 0;
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		//t++;
		player.update();
		balletManager_p.update();
		balletManager_e.update();
		enemyManager.update();
		eg.update();
		
	}
/**
 * privateメソッド　このメソッドはEnemyManagerに実装を移動することを要検討
 * 使用不可
 * @param time
 */
	private void generete(int time) {
	//	ArrayList<Enemy> list = new ArrayList<Enemy>();
	//	list = generater.getGenereteEnemyList(time, 1);
	//	generater.GenereteEnemy(time, 1);
		
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		eg.draw(d);
		player.draw(d);
		balletManager_p.draw(d);
		balletManager_e.draw(d);
		enemyManager.draw(d);
	}

}
