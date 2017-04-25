package Ballet;
import java.util.ArrayList;

import densan.s.game.drawing.Drawer;

/**
 * 弾のリストを保持するクラス singleton
 * @author tachibana
 *
 */
public class BalletManager {
/**
 * クラスを読み込んだ際にオブジェクトの生成をする
 */
	private static final BalletManager balletManager = new BalletManager();
	/**
	 * 弾のリスト
	 */
	private static ArrayList<StraightBallet> balletlist;
	/**
	 * コンストラクタ 最初の一回のみ実行 private
	 */
	private BalletManager(){
		balletlist = new ArrayList<StraightBallet>();
	}
	/**
	 * リストにバレットを追加
	 * @param addBallet
	 */
	public void balletAdd(StraightBallet addBallet){
		balletlist.add(addBallet);
	}
	/**
	 * update balletlistをupdateする
	 */
	public void update(){
		for(StraightBallet b: balletlist){
			//x=640,y=480 弾の座標判定
			if(b.getX()<0||b.getX()>640||b.getY()<0||b.getY()<480)
			b.update();
		}
	}
	/**
	 * balletlist全てにdrawする
	 * @param d
	 */
	public void draw(Drawer d){
		for(StraightBallet b: balletlist){
			b.draw(d);
		}
	}
	/**
	 * getInstance
	 * @return
	 */
	public static BalletManager getInstance(){
		return balletManager;
	}
	/**
	 * オブジェクトの消去
	 */
	public void delete(Ballet b){
	//	for(Ballet listInBallet:balletlist){
				while(balletlist.remove(b));
		}
	
	
}
