package enemy;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.Box.Filler;

import objects.Cloud;
import densan.s.game.drawing.Drawer;
//横 640
//縦 480
//
/**
 * stage1のエネミーを生成する
 * @author tachibana
 *
 * @param <T>
 * @param <Cloud>
 */
public class StageConstoracter1 implements StageConstoracter{
	/**
	 * エネミーマネージャーへの参照
	 */
	private List<Enemy> manager = EnemyManager.getInstance().getList();
	
	public StageConstoracter1(){
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
		case 120: 
			manager.add(new Enemy_BallType2(640, 200));
			break ;
		case 180:
			manager.add(new Enemy_BallType1(640, 200));
			break;
		case 240:
			manager.add(new Enemy_BallType1(640, 200));	
			break;
		case 700:		
			manager.add(new Enemy_BallType1(640,70));
			break;
		case 760:		
			manager.add(new Enemy_BallType1(640,70));
			break;
		case 820:		
			manager.add(new Enemy_BallType1(640,70));
			break;
		case 1280:
			manager.add(new Enemy_BallType1(640,400));
			break;
		case 1340:
			manager.add(new Enemy_BallType1(640,400));
			break;
		case 1400:
			manager.add(new Enemy_BallType1(640,400));
			break;
		case 1680:
			manager.add(new Enemy_BallType2(640, 200));
			break;
		case 1740:
			manager.add(new Enemy_BallType2(640, 200));
			break;
		case 1800:
			manager.add(new Enemy_BallType2(640, 200));
			break;
			
		case 2600:
			manager.add(new BossEnemy1());


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
	
	}
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	public void draw(Drawer d){
		  d.setColor(Color.CYAN);
		  d.fillRect(0, 0, 640, 480);
		 Iterator<Cloud> itr  = clouds.iterator();
		 while(itr.hasNext()){
			 Cloud c = itr.next();
			 c.draw(d);
		 }
	}
}
