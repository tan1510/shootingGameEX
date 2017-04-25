package enemy.enemy_move;
/**
 * Stateパターン
 * MoveTypeの実装
 * 
 * 多分←等速直線運動にする(yVector=0.0,xVcetor=-n)
 * @author tachibana
 *
 */
public class MoveType1 implements MoveType {
	/**
	 * コンストラクタ
	 */
	public MoveType1(){
		
	}

	@Override
	public double getXVector() {
		// TODO 自動生成されたメソッド・スタブ
		return -5;
	}

	@Override
	public double getYVcotoe() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
