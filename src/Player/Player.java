package Player;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import Ballet.PlayerSetRadBallet;
import scene.Game;
import scene.GameOverScene;
import shootAction.ShootAction;
import shootAction.StraightShoot;
import shootAction.ThreeWayShoot;
import shootAction.TwoWayShoot;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
import densan.s.game.object.GameObjectBase;
 
 /**
  * プレイヤーのオブジェクト<br>
  * ゲーム開始時にstartメソッドを実行すること<br>
  * @author tachibana
  *
  */
public class Player extends GameObjectBase {
	/**
	 * 所持金(テストとして99999初期値)
	 */
	private int money = 5000;
	/**
	 * ステージでゲットしたお金を保持するフィールド
	 */
	private static int dropmoney = 0;
	/**
	 * 攻撃力　初期値1 <br>
	 * ショップでの強化での値は仕様書参照のこと
	 */
	private int power = 1;
	/**
	 * 移動スピード(初期値2)<br>
	 * ショップでの強化での値は仕様書参照のこと
	 */	
	private int SPEED = 2;
	/**
	 * 初期の残機数(初期値3)<br>
	 * ショップでの強化での値は仕様書参照のこと
	 */
	private int MAX_LIFE = 3; 
	/**
	 * 現在の残機 <br>
	 * とりあえず初期値としては1突っ込んでおき.startメソッドでMAXLIFEを代入
	 */
	private static int LIFE = 1;
	/**
	 * playerの横サイズ(初期値 50)<br>
	 * ショップでの強化での値は仕様書参照のこと
	 */
	private static int width =50;
	/**
	 * playerの縦サイズ(初期値 25)<br>
	 * ショップでの強化での値は仕様書参照のこと
	 */
	private static int height = 25;
	/**
	 * State　射撃タイプの保持およびstraightShootで初期化
	 */
	private ShootAction shootAction = new StraightShoot(this);
	/**
	 * Playerのイメージ クラスが呼ばれた際に参照を保持
	 */
	private static final Image image = ImageLoader.load("image/paperfly.png");
	/**
	 * ダメージを受けた際に表示するイメージ
	 */
	private static final Image isDamegedImage = ImageLoader.load("");
	/**
	 * 
	 */
	private static final Image STATU_VAR = ImageLoader.load("image/statusVAR.png"); 
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
	 * 
	 */
	private Drawer lastD;
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
	private boolean isGameover = false;

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
			addY(-getSPEED());
		}
		if (KeyInput.isPressing(KeyEvent.VK_DOWN)) {
			addY(getSPEED());
		}
		if (KeyInput.isPressing(KeyEvent.VK_RIGHT)) {
			addX(getSPEED());
		}
		if (KeyInput.isPressing(KeyEvent.VK_LEFT)) {
			addX(-getSPEED());
		}
		if(KeyInput.isPressing(KeyEvent.VK_Z)){
			if(waitTime>getShootAction().getWaitTime()){
			getShootAction().shoot(power); //射撃
			waitTime=0;
			}
		}
			waitTime++;
		
		//120fで無敵解除
		if(invinsible){
			invisibleCount++;
			if(invisibleCount>120){
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
		if(LIFE==0){
			isGameover  = true;
			Game.isGameOver();
		}
	}
	/**
	 * ゲームオーバー  
	 * 仕様していない
	 */
	public void gameOver(){
		GameManager.getInstance().setUpdatable(new GameOverScene(lastD));
	}
 
	
	@Override
	/**
	 * densangamelibraryのgameObjectbaseが標準で持つ描画メソッド
	 * @param d
	 */
	public void draw(Drawer d) {
		if(!isGameover){
		if(invinsible){
			d.setColor(Color.BLUE);
			d.fillRect(getX(), getY(), getWidth(), getHeight());
		}else {
		d.drawImage(image, (int)getX(), (int)getY(),getWidth(),getHeight());

		lastD = d;
		}
		}
	}
	/**
	 * ステータスの描画
	 */
	public static void drawStatus(Drawer d){
		d.drawScaleImage(STATU_VAR, 30, 430, 2.5);
		d.setFontSize(30);
		d.setColor(Color.BLACK);
		d.drawString("LIFE ",45, 470);
		d.setColor(Color.RED);
		d.drawString(String.valueOf(LIFE), 145, 470);
	}
	
	/**
	 * 射撃タイプのStateを返す
	 */
	public ShootAction getShoottype(){
		return getShootAction();
	}
 /**
  * ステージの開始時に呼び、プレイヤーのライフと座標などの初期化を行う
  */
	public void start(){
		setX(100);
		setY(220);
		LIFE=getMAX_LIFE();
		dropmoney = 0;
		isGameover=false;
	}
	
	public int getPower(){
		return power;
	}
	
	public void setPower(int power){
		this.power=power;
	}

	public int getSPEED() {
		return SPEED;
	}

	public void setSPEED(int sPEED) {
		SPEED = sPEED;
	}

	public int getMAX_LIFE() {
		return MAX_LIFE;
	}

	public void setMAX_LIFE(int mAX_LIFE) {
		MAX_LIFE = mAX_LIFE;
	}

	public ShootAction getShootAction() {
		return shootAction;
	}

	public void setShootAction(ShootAction shootAction) {
		this.shootAction = shootAction;
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public static int getDropmoney() {
		return dropmoney;
	}

	public static void addDropmoney(int money) {
		dropmoney += money;
	}
}