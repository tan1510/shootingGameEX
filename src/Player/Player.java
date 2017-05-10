package Player;
import java.awt.Color;
import java.awt.event.KeyEvent;

import shootAction.ShootAction;
import shootAction.StraightShoot;
import densan.s.game.drawing.Drawer;
import densan.s.game.input.KeyInput;
import densan.s.game.object.GameObjectBase;
 
 /**
  * プレイヤーのオブジェクト
  * @author tachibana
  *
  */
public class Player extends GameObjectBase {
 /**
  * 移動スピード
  */
	private int SPEED = 2;
	/**
	 * playerの横サイズ
	 */
	private static int width =50;
	/**
	 * playerの縦サイズ
	 */
	private static int height = 50;
	/**
	 * State　射撃タイプの保持およびstraightShootで初期化
	 */
	private ShootAction shootAction = new StraightShoot(this);
	
	private static Player player  = new Player();
	/**
	 * getInsatance
	 * @return
	 */
	public static Player getInstance(){
		return player;
	}
 /**
  * コンストラクタ　
  * ShootActionの初期化
  */
	private Player() {
		super(100, 100, width, height);
		
	}
	private int waitTime=10;
 /**
  * update
  */
	@Override
	public void update() {
		//移動
		if (KeyInput.isPressing(KeyEvent.VK_UP)) {
			addY(-SPEED);
		}
		if (KeyInput.isPressing(KeyEvent.VK_DOWN)) {
			addY(SPEED);
		}
		if (KeyInput.isPressing(KeyEvent.VK_RIGHT)) {
			addX(SPEED);
		}
		if (KeyInput.isPressing(KeyEvent.VK_LEFT)) {
			addX(-SPEED);
		}
		if(KeyInput.isPressing(KeyEvent.VK_Z)){
			if(waitTime>10){
			shootAction.shoot(); //射撃
			waitTime=0;
			}
			waitTime++;
		}
	}
 
 
	/**
	 * densangamelibraryのgameObjectbaseが標準で持つ描画メソッド
	 */
	@Override
	public void draw(Drawer d) {
		d.setColor(Color.BLUE);
		d.fillRect(getX(), getY(), getWidth(), getHeight());
 
	}
	/**
	 * 射撃タイプのStateを返す
	 */
	public ShootAction getShoottype(){
		return shootAction;
	}
 
}