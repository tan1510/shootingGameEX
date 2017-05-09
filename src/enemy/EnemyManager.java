package enemy;

import java.util.ArrayList;

import densan.s.game.calc.Calc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Ballet.Ballet;
import Ballet.PlayerBalletManager;
import Ballet.StraightBallet;
import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;

/**
 * 全てのenemyをArrayListとして持ちupdateとdrawを一括でできるようにする
 * シングルトンパターン
 * @author tachibana
 *
 */
public class EnemyManager <T extends Enemy>{
	/**
	 * ゲームオブジェクトのリスト
	 */
	private List<T> objectList = new LinkedList<T>();
	/**
	 * クラスを読み込んだ時インスタンスを生成
	 */
	private static EnemyManager enemyManager = new EnemyManager();
	/**
	 * 全てのエネミーを持つArrayList
	 */
	private List<T> enemyList;
	/**
	 * コンストラクター アレイリストの初期化
	 */
	private EnemyManager(){
		 enemyList = new LinkedList<T>();
	}
	
	/**
	 * enemyをaddに追加
	 * @param enemy
	 */
	public void addEnemy(T enemy){
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
		Iterator<T> itr =  enemyList.iterator();
		T e;
		while(itr.hasNext()){
			e = itr.next();
			e.update();
			Iterator<Ballet> itrb = PlayerBalletManager.getInstance().getList().iterator();
			Ballet b;
			while(itrb.hasNext()){
				b = itrb.next();
				//double eX = e.getX(),eY=e.getY(),bX=b.getX(),bY=b.getY();
				if(Calc.collisionDetection(b, e)){
				e.getDamage(b.getPower());
				b.remove();
				}
			}
		}
		
		itr =  enemyList.iterator();
		while(itr.hasNext()){
			e = itr.next();
		//	System.out.println(e.isRemove());
			if(e.isRemove()){
				itr.remove();
			}
		}	
	}
	/**
	 * ゲッター
	 * @return
	 */
	public List<T> getList(){
		return enemyList;
	}
}
