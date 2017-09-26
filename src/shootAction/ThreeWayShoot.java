package shootAction;

import Ballet.PlayerBalletManager;
import Ballet.PlayerSetRadBallet;
import Ballet.StraightBallet;
import densan.s.game.object.GameObjectBase;

public class ThreeWayShoot implements ShootAction{
	/**
	 * 次弾発射までのインターバル
	 */
	private static final int waitTime = 10; 
	
	/**
	 * ShootActionをもつGameObjectへのアクセス
	 */
	private GameObjectBase o;
	/**
	 * 弾のマネージャー
	 */
	private PlayerBalletManager balletManager;
	
	private double rad1 = Math.PI/10.0;
	private double rad2 = Math.PI/10.0*11.0;
	
	public ThreeWayShoot(GameObjectBase o){
		this.o=o;
		balletManager=PlayerBalletManager.getInstance();
		
	}
	/**
	 * 
	 * @param length 半径（大きいほど弾速が上がる)
	 * @param deg 
	 */
	@Override
	public void shoot(int damage) {
		System.out.println(rad1);
				balletManager.balletAdd(new StraightBallet(o.getCenterX(),o.getCenterY(),damage));	
				balletManager.balletAdd(new PlayerSetRadBallet(o.getCenterX(), o.getCenterY(), damage,rad1));
				balletManager.balletAdd(new PlayerSetRadBallet(o.getCenterX(), o.getCenterY(), damage,-rad2));
	}
	
	
	@Override
	public int getWaitTime() {
		// TODO 自動生成されたメソッド・スタブ
		return waitTime;
		
	}
}