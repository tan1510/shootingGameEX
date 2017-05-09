package enemy;

import java.util.List;
/**
 * stage1のエネミーを生成する
 * @author tachibana
 *
 * @param <T>
 */
public class EnemyGeneretor1<T extends Enemy> implements EnemyGeneretor{
	private List<T> manager = EnemyManager.getInstance().getList();
	
	public EnemyGeneretor1(){
	}
	
	public void update(int time){
		switch(time){
		case 0: 
			EnemyManager.getInstance().addEnemy(new Enemy_BallType1(400, 400));
			
		
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
			EnemyManager.getInstance().addEnemy(new Enemy_BallType1(400, 400));
		time++;
	}
	}
	
}
