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
	public static final int SPEED = 2;
	/**
	 * State　射撃タイプの保持およびstraightShootで初期化
	 */
	private ShootAction shootAction = new StraightShoot(this);
 /**
  * コンストラクタ　
  * ShootActionの初期化
  */
	public Player() {
		super(100, 100, 50, 50);
		
	}
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
			getShoottype().shoot(50,0); //射撃
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