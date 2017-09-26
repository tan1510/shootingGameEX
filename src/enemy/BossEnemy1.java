package enemy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;

import Ballet.EnemyBalletManager;
import Ballet.EnemyStraightBallet;
import Ballet.StraightBallet;
import Player.Player;
import densan.s.game.calc.Calc;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.object.GameRectBase;
import scene.Game;
/**
 * stage1のボス
 * @author tachibana
 *
 */
public class BossEnemy1 extends Enemy {
	/**
	 * 画像のロード
	 */
	private final static Image image = ImageLoader.load("image/dentyuu.png");
	
	private final static Image HP_VAR = ImageLoader.load("image/HP_bar.png");
	/**
	 *EnemyBalletManagerへの参照
	 */
	private final static EnemyBalletManager ballets = EnemyBalletManager.getInstance();
	/**
	 * プレイヤーへの参照
	 */
	private final static Player player = Player.getInstance();
	/**
	 * 最大HP
	 */
	private final static int MAX_HP = 40;
	/**
	 * 現在HP
	 */
	private int hp;
	/**
	 * 撃破時に得られる金額
	 */
	private final static int DROPMONEY = 500;
	/**
	 * 
	 */
	private final static Random r = new Random();
	/**
	 * 
	 */
	public BossEnemy1() {
	//	super(300,300,142,400);
		super(782+100,130 , 142, 380);
		// TODO 自動生成されたコンストラクター・スタブ
		hp = 40;
		this.setVx(-3);
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.drawImage(image, getX(), getY());
		drawHp(d);
	}

	@Override
	public void shoot() {
		// TODO 自動生成されたメソッド・スタブ
	
		if(r.nextInt(10)<2){
			int error = r.nextInt(30)+1-15;
			double errorRad =error*Math.PI/180;
		
			Point2D.Double p1 = new Point2D.Double();
			p1.setLocation(getX()+20, getY()+40);
			Point2D.Double p2= new Point2D.Double();
			p2.setLocation(player.getX(), player.getY());
			
			ballets.balletAdd(new EnemyStraightBallet(getX()+20, getY()+40,errorRad+Calc.getRadian(p1, p2)));
		}
		

	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		if(getX()>540){
		move();
		}else{
			shoot();
		}
	//	System.out.println(getX());
	}

	@Override
	public void getDamage(int damage) {
		// TODO 自動生成されたメソッド・スタブ
		hp-= damage;
		if(hp<0){
			//ここにボス撃破時の処理
			Player.addDropmoney(DROPMONEY);
			Game.isCleared();
			
			remove();
		}
		
	}
	
	private int count = 0;
	/**
	 * 
	 * @param d
	 */
	private void drawHp(Drawer d){
	
		d.setColor(Color.RED);
		d.setFont(new Font("Arial",Font.ITALIC , 30));
		d.drawString("BOSS", 10, 30);
		// n = hp*100/MAX_HP;
		//System.out.println(n);
		d.fillRect(130, 10, hp*10, 30);
		d.drawImage(HP_VAR, 129, 10);
	}
	/**
	public static void main(String[] args){
		Random r = new Random();
		while(true){
			int a = r.nextInt(10);
			System.out.println(a);
		}
	}
	*/
	

}
