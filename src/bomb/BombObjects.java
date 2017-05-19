package bomb;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * ボムオブジェクトのリスト
 * @author tachibana
 *
 */
public class BombObjects <T extends Bomb>{
	/**
	 * singleton<br>
	 * クラスを読み込んだ際にオブジェクトの生成
	 */
	private static final BombObjects bombObjects = new BombObjects();
	/**
	 * bombオブジェクトのリスト
	 */
	private ArrayList<Bomb> list;

	/**
	 * コンストラクタ　
	 * <br>bombリストの初期化
	 */
	private BombObjects(){
		list= new ArrayList<Bomb>();
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static BombObjects getInstance(){
		return bombObjects;
	}
	/**
	 * リスト全てのオブジェクト(Bomb)
	 * にupdateを実行しリムーブフラグが立っていればiteratorのremoveを実行
	 */
	public void update(){
		Iterator<Bomb> itr = list.iterator();
	
		while(itr.hasNext()){
			Bomb b = itr.next();
			b.update();
			
			if(b.isRemove())
				itr.remove();
		}
	}
	
	
	/**
	 * ゲッター
	 * @return bombList
	 */
	public ArrayList<Bomb> getList(){
		return list;
	}
}
