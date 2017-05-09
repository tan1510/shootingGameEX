package Ballet;

import java.util.ArrayList;

import densan.s.game.drawing.Drawer;

public class EnemyBalletManager <T extends Ballet>{
	/**
	 * クラスを読み込んだ際にオブジェクトの生成をする
	 */
		private static final EnemyBalletManager balletManager = new EnemyBalletManager();
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
		private EnemyBalletManager(){
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
		public static EnemyBalletManager getInstance(){
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