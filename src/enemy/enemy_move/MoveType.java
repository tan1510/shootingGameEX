package enemy.enemy_move;
/**
 * Steteとして全てエネミーが持つ
 * getXVecotr等でvectorを取得
 * @author tachibana
 *
 */
public interface MoveType {
	/**
	 * そのムーブタイプでのxベクトルを取得する
	 * @return
	 */
	public double getXVector();
	/**
	 * 
	 * @return
	 */
	public double getYVcotoe();

}
