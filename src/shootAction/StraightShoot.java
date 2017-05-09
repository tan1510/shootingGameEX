package shootAction;
import Ballet.StraightBallet;
import Ballet.PlayerBalletManager;
import densan.s.game.object.GameObjectBase;

/**
 * 射撃の仕方の一つ
 * @author tachibana
 *
 */
public class StraightShoot implements ShootAction{
	/**
	 * ShootActionをもつGameObjectへのアクセス
	 */
	private GameObjectBase o;
	/**
	 * 弾のマネージャー
	 */
	private PlayerBalletManager balletManager;
	
	public StraightShoot(GameObjectBase o){
		this.o=o;
		balletManager=PlayerBalletManager.getInstance();
		
	}
	/**
	 * 
	 * @param length 半径（大きいほど弾速が上がる)
	 * @param deg 
	 */
	@Override
	public void shoot() {
				balletManager.balletAdd(new StraightBallet(o.getCenterX(),o.getCenterY()));	
	}

}
