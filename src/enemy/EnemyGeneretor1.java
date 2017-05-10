package enemy;

import java.util.List;
//横 640
//縦 480
//
/**
 * stage1のエネミーを生成する
 * @author tachibana
 *
 * @param <T>
 */
public class EnemyGeneretor1<T extends Enemy> implements EnemyGeneretor{
	/**
	 * エネミーマネージャーへの参照
	 */
	private List<Enemy> manager = EnemyManager.getInstance().getList();
	
	public EnemyGeneretor1(){
	}
	
	public void update(int time){
		switch(time){
		case 0: 
		
			
			
			
		
		}
	}
/**
 * 経過時間
 */
	private int time = 0;
	/**
	 * 
	 */
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		switch(time){
		case 0: 
			manager.add(new Enemy_BallType1(600, 400));
			manager.add(new Enemy_BallType1(600, 300));
			manager.add(new Enemy_BallType1(600, 200));
			manager.add(new Enemy_BallType1(600, 100));
			
		default:
			break;
	}
		time++;
	}
	
}
