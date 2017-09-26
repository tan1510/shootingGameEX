package enemy;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import objects.Cloud;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;

public class StageConstrcter2 implements StageConstoracter {

	/**
	 * エネミーマネージャーへの参照
	 */
	private List<Enemy> manager = EnemyManager.getInstance().getList();
	/**
	 * 背景イメージ参照その１
	 */
	private final static Image BGIMAGE1 = ImageLoader.load("image/stage2bg.png");
	private final static Image BGIMAGE2 = ImageLoader.load("image/stage2bg.png");
	public StageConstrcter2(){
		manager.isEmpty();
	}
	/**
	 * update 引数込みで　使用しない
	 * @param time
	 */
	public void update(int time){
		switch(time){
		case 0:
		
		}
	}
/**
 * 経過時間
 */
	private int time = 0;
	private ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	/**
	 * 
	 */
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		switch(time){
		case 0: 
	//		manager.add(new Enemy_BallType1(600, 400));
		//	manager.add(new Enemy_BallType1(640, 220));
			manager.add(new BossEnemy1());
		case 60:
			//manager.add(new Enemy_BallType1(640, 220));
			
		case 120:
//			manager.add(new Enemy_BallType1(640, 220));
		case 180:
//			manager.add(new Enemy_BallType1(640, 220));
		default:
			break;
	}
		//
		Iterator<Cloud> itr = clouds.iterator();
		while(itr.hasNext()){
			Cloud c = itr.next();
			c.update();
			if(c.getX()<-30)
			itr.remove();
		}
		time++;
		
	
		Random r = new Random(); 
		if(r.nextInt(48)==0){
			clouds.add(new Cloud(640,200-r.nextInt(280)));
		//	System.out.println("cloud");
		
	}
		if(bgcount1==320){
			bgcount1=0;
		}else{
		bgcount1++;
		}
		
		if(bgcount2==320){
			bgcount2=0;
		}else{
		bgcount2++;
		}
	
	}
	/**
	 * 背景の画像のx座標のためのフィールド
	 */
	private int bgcount1 = 0;
	private int bgcount2 = 0;
 	/**
	 * 
	 */
	public void draw(Drawer d){
		d.drawImage(BGIMAGE1, 0-bgcount1*4, 0);
		d.drawImage(BGIMAGE1, 1280-bgcount2*4, 0);
		 Iterator<Cloud> itr  = clouds.iterator();
		 while(itr.hasNext()){
			 Cloud c = itr.next();
			 c.draw(d);
		 }
	}
}
