package enemy;

import java.util.ArrayList;

import Ballet.StraightBallet;
import densan.s.game.drawing.Drawer;

/**
 * 全てのenemyをArrayListとして持ちupdateとdrawを一括でできるようにする
 * シングルトンパターン
 * @author tachibana
 *
 */
public class EnemyManager {
	/**
	 * クラスを読み込んだ時インスタンスを生成
	 */
	private static EnemyManager enemyManager = new EnemyManager();
	/**
	 * 全てのエネミーを持つArrayList
	 */
	private ArrayList<Enemy> enemyList;
	
	/**
	 * コンストラクター アレイリストの初期化
	 */
	private EnemyManager(){
		 enemyList = new ArrayList<Enemy>();
	}
	
	/**
	 * enemyをaddに追加
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy){
		enemyList.add(enemy);
	}
	
	/**
	 * getInstance
	 * @return
	 */
	public static EnemyManager getInstance(){
		return enemyManager;
	}
	/**
	 * 全てのenemyを描画
	 * @param d 描画
	 */
	public void draw(Drawer d){
		for(Enemy e: enemyList){
			e.draw(d);
		}
	}
	
	/**
	 * 全てのenemyをupdate
	 */
	public void update(){
		for(Enemy e: enemyList){
			e.update();
				}
	}
}
