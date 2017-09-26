package Ballet;
import java.util.ArrayList;
import java.util.Iterator;

import Player.Player;
import densan.s.game.calc.Calc;
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
	 * 横方向の画面サイズ
	 */
	private static final int MaxX =640;
	/**
	 * 縦方向の画面サイズ
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
	public void balletAdd(Ballet addBallet){
		balletlist.add(addBallet);
	}
	/**
	 *リスト全てのオブジェクト(Ballet)
	 * にupdateを実行しリムーブフラグが立っていればiteratorのremoveを実行
	 */
	public void update(){
		Iterator<Ballet> itr = balletlist.iterator();
		Ballet b;
		
		
		while(itr.hasNext()){
			//x=640,y=480 弾の座標判定
			b =itr.next();
			b.update();

			if(b.getX()<0||b.getX()>MaxX||b.getY()<0||b.getY()>MaxY)//弾が画面外にあるかの判定
				b.remove();
		
			
			if(b.isRemove())//removeフラグ
				itr.remove();
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
	@SuppressWarnings("rawtypes")
	public static PlayerBalletManager getInstance(){
		return balletManager;
	}
	
	
	/**
	 * オブジェクトの消去
	 */
	public void listClear(){
	//	for(Ballet listInBallet:balletli
		balletlist.clear();
		}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Ballet> getList(){
		return balletlist;
		
	}
	
	
}
