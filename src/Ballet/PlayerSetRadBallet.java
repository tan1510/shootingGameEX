package Ballet;

import java.awt.Image;

import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;

public class PlayerSetRadBallet extends Ballet {

	/**
	 * xベクトル とりあえず初期値10
	 */
	private double xVector=10;
	/**
	 * yベクトル とりあえず初期値10に設定
	 */
	private double yVector=10; 
	/**
	 * boolean プレイヤーが放った弾であるかどうか
	 */
	private boolean playerBallet = true;
	/**
	 * 弾の威力 
	 */
	private int power = 1;
	private int length =20;
	private final static Image image = ImageLoader.load("image/ballet1.png");
	/**
	 * 弾コンストラクタ
	 * @param x x座標
	 * @param y y座標
	 * @param length 半径
	 * @param deg  角度
	 */
	public PlayerSetRadBallet(double x, double y,int power,double rad) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(x, y, 10,10 );
		this.power=power;
		//ベクトル設定
		xVector =length * Math.sin(rad);
		yVector =length * Math.cos(rad);

		System.out.println("x:"+xVector);
		System.out.println("y:"+yVector);
		this.setVector(xVector, yVector);
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
	}
/**bulletの描画
 * 
 */
	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.drawImage(image, getX()-5, getY()-5);
	//	d.setColor(Color.BLACK);
		//d.fillCircle(this.getX(), this.getY(),2);
	}
	/**
	 * 威力のゲッター
	 */
	public int getPower(){
		return power;
	}

}
