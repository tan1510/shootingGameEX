package Ballet;
import java.util.ArrayList;

import densan.s.game.drawing.Drawer;
import densan.s.game.object.GameObjectBase;

/**
 * 弾のリストを保持するクラス singleton
 * @author tachibana
 *
 */
public class PlayerBalletManager <T extends Ballet>{
/**
 * クラスを読み込んだ際にオブジェクトの生成をする
 */
	private static final PlayerBalletManager balletManager = new PlayerBalletManager();
	/**
	 * 弾のリスト
	 */
	private static ArrayList<Ballet> balletlist;
	/**
	 * 画面サイズ
	 */
	private static final int MaxX =640;
	/**
	 * 画面サイズ
	 */
	private static final int MaxY =480;
	/**
	 * コンストラクタ 最初の一回のみ実行 private
	 */
	private PlayerBalletManager(){
		balletlist = new ArrayList<Ballet>();
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
		for(Ballet b: balletlist){
			//x=640,y=480 弾の座標判定
			b.update();
			if(b.getX()<0||b.getX()>MaxX||b.getY()<0||b.getY()<MaxY)
			b.remove();
		}
	}
	/**
	 * balletlist全てにdrawする
	 * @param d
	 */
	public void draw(Drawer d){
		for(Ballet b: balletlist){
			b.draw(d);
		}
	}
	/**
	 * getInstance
	 * @return
	 */
	public static PlayerBalletManager getInstance(){
		return balletManager;
	}
	/**
	 * オブジェクトの消去
	 */
	public void delete(Ballet b){
	//	for(Ballet listInBallet:balletlist){
				while(balletlist.remove(b));
		}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Ballet> getList(){
		return balletlist;
		
	}
	
	
}
