package Player;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import shootAction.ShootAction;
import shootAction.StraightShoot;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.input.KeyInput;
import densan.s.game.object.GameObjectBase;
 
 /**
  * プレイヤーのオブジェクト
  * @author tachibana
  *
  */
public class Player extends GameObjectBase {
 /**
  * 移動スピード(初期値2)
  */
	private int SPEED = 2;
	/**
	 * 初期の残機数(初期値3)
	 */
	private int MAX_LIFE = 3; 
	/**
	 * 現在の残機(初期値1)
	 */
	private int LIFE = 1;
	/**
	 * playerの横サイズ(50)
	 */
	private static int width =50;
	/**
	 * playerの縦サイズ(25)
	 */
	private static int height = 25;
	/**
	 * State　射撃タイプの保持およびstraightShootで初期化
	 */
	private ShootAction shootAction = new StraightShoot(this);
	/**
	 * Playerのイメージ
	 */
	private static final Image image = ImageLoader.load("image/紙飛行機.png");
	/**
	 * 無敵フラグ
	 */
	private boolean invinsible = false;
	/**
	 * インスタンス
	 * <br>クラスを読み込んだ時に初期化
	 */
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
		super(100, 220, width, height);	
	}
	
	/**
	 * 弾の発射間隔(現在使用不可)
	 */
	private int waitTime=10;
	/**
	 * 無敵時間のカウント
	 */
	private int invisibleCount = 0;

 /**
  * update
  * <br>移動四方向
  * <br>射撃
  * <br>無敵時間の処理
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
			if(waitTime>shootAction.getWaitTime()){
			shootAction.shoot(); //射撃
			waitTime=0;
			}
			waitTime++;
		}
		
		//60fで無敵解除
		if(invinsible){
			invisibleCount++;
			if(invisibleCount>30){
				//無敵関係の数値を初期化
				invinsible= false;
				invisibleCount = 0;
			}
		}
	}
 /**
  * ダメージを受ける
  */
	public void damage(){
		if(!invinsible){
			LIFE--;
			System.out.println("im");
			invinsible = true;
		}
	}
 
	
	@Override
	/**
	 * densangamelibraryのgameObjectbaseが標準で持つ描画メソッド
	 * @param d
	 */
	public void draw(Drawer d) {
		if(invinsible){
			d.setColor(Color.BLUE);
			d.fillRect(getX(), getY(), getWidth(), getHeight());
		}else
		d.drawImage(image, getX(), getY());
//		d.setColor(Color.BLUE);
//		d.fillRect(getX(), getY(), getWidth(), getHeight());
		
// 
	}
	/**
	 * 射撃タイプのStateを返す
	 */
	public ShootAction getShoottype(){
		return shootAction;
	}
 
}