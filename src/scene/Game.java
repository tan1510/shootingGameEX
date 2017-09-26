package scene;


import java.awt.Color;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Ballet.Ballet;
import Ballet.EnemyBalletManager;
import Ballet.PlayerBalletManager;
import Player.Player;
import densan.s.game.drawing.Drawer;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
import densan.s.game.manager.Updatable;
import enemy.Enemy;
import enemy.StageConstrcter2;
import enemy.StageConstoracter;
import enemy.StageConstoracter1;
import enemy.StageConstoracter3;
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
	private Player player = Player.getInstance();
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
 * ゲームオーバーフラグ
 * 
 */
	private static boolean isGameOver = false;
//	private BGM bgm;
	/**
	 * 
	 */
	private static boolean isCleared = false;
	/**
	 * コンストラクタ
	 */
	public Game(int stageNum){
		isCleared = false;
		isGameOver= false;
		player.start();
		balletManager_p = PlayerBalletManager.getInstance();
		balletManager_e = EnemyBalletManager.getInstance();
		enemyManager = EnemyManager.getInstance();
		switch(stageNum){
			case 1:
				eg = new StageConstoracter1();
				break;
			case 2:
				eg = new StageConstrcter2();
				break;
			case 3:
				eg = new StageConstoracter3();
				break;
				
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
		if(!isGameOver){
		player.update();
		}else{
			Iterator<Enemy> itr = enemyManager.getList().iterator();
					while(itr.hasNext()){
						Enemy e = itr.next();
						e.remove();
					}
			if(KeyInput.isPress(KeyEvent.VK_X)){
				GameManager.getInstance().setUpdatable(new Menu());
			}
		}
		if(isCleared){
			balletManager_e.deleteAllBallet();
			if(KeyInput.isPress(KeyEvent.VK_X)){
				GameManager.getInstance().setUpdatable(new Menu());
			}
		}
		balletManager_p.update();
		balletManager_e.update();
		enemyManager.update();
		eg.update();
		
		
	}
/**
 * privateメソッド　このメソッドはEnemyManagerに実装を移動することを要検討<br>
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
		player.drawStatus(d);
		if(isGameOver){
			isGameOverDraw(d);
		}else if(isCleared){
			isClearDraw(d);
		}
		
	}
	/**
	 * ゲームオーバーフラグをtrueにする
	 */
	public static void isGameOver(){
		Player.getInstance().addMoney(Player.getDropmoney()/3);
		System.out.println(Player.getInstance().getMoney());
		isGameOver = true;
	}
	/**
	 * クリアフラグをtrueにする
	 */
	public static void isCleared(){
		Player.getInstance().addMoney(Player.getDropmoney());
		isCleared =true;
	}
	/**
	 * ゲームオーバーフラグがtrueの時にdrawメソッドで呼び出す描画メソッド
	 * @param d
	 */
	private void isGameOverDraw(Drawer d){
		d.setFontSize(40);
		d.setColor(Color.RED);
		d.drawStringCenter("GAMEOVER", 340, 200);
		d.setFontSize(20);
		d.setColor(Color.BLACK);
		d.drawString(Player.getDropmoney()/3+" G を獲得しました", 390, 250);
		d.drawString("PLEASE PUSH X", 410, 270);
	}
	
	/**
	 * Clearフラグがtrueの時にdrawメソッドで呼び出す描画メソッド
	 * @param d
	 */
	private void isClearDraw(Drawer d){
		d.setFontSize(40);
		d.setColor(Color.RED);
		d.drawStringCenter("STAGECLEAR", 340, 200);
		d.setFontSize(20);
		d.setColor(Color.BLACK);
		d.drawString(Player.getDropmoney()+" G を獲得しました", 390, 250);
		d.drawString("PLEASE PUSH X", 410, 270);
	}
	/**
	 * 
	 */

}
