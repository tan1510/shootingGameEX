package scene;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
import densan.s.game.manager.Updatable;


public class StageSelect implements Updatable {

	/**
	 *イメージへの参照を生成して保持
	 */
	private static final Image image = ImageLoader.load("image/select.png");
	/**
	 * 選択ステージを表す
	 */
	private int state = 1;
	/**
	 * ステージの選択決定ウィンドウを表示するか否か
	 */
	private boolean isSelecting = false;
	/**
	 * 決定確認画面での意思確認
	 */
	private boolean decisive = false;
	@Override
	/**
	 * 
	 */
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		//選択状態の遷移
		if(!isSelecting){
		if(KeyInput.isPress(KeyEvent.VK_RIGHT)){
			if(state%3!=0){
				state++;
				}
			}else if(KeyInput.isPress(KeyEvent.VK_LEFT)){
				if(state%3!=1){
					state--;
				}
			}else if(KeyInput.isPress(KeyEvent.VK_DOWN)){
				if(state<7){
					state+=3;	
				}
			}else if(KeyInput.isPress(KeyEvent.VK_UP)){
				if(state>3){
					state-=3;
				}
			}else if(KeyInput.isPress(KeyEvent.VK_Z)){	
				if(state==1||state==2){		
					isSelecting=true;
				}
			}else if(KeyInput.isPress(KeyEvent.VK_X)){
				GameManager.getInstance().setUpdatable(new Menu());
			}
		
		//ここまでが選択してない場合の処理
		
		}
		else//ここから選択中の処理
		{
			if(decisive){   //意思決定時　決定選択時の処理
				if(KeyInput.isPress(KeyEvent.VK_Z)){
					GameManager.getInstance().setUpdatable(new Game(state));
				}else if(KeyInput.isPress(KeyEvent.VK_X)){
					decisive=false;
					isSelecting=false;
				}else if(KeyInput.isPress(KeyEvent.VK_LEFT)){
					isSelecting= false;
				}
				
			}else {//意思決定時　キャンセル時の処理
				if(KeyInput.isPress(KeyEvent.VK_X)||KeyInput.isPress(KeyEvent.VK_Z)){
					isSelecting=false;
				}else if(KeyInput.isPress(KeyEvent.VK_RIGHT)){
					decisive = true;
				}
		}
		}
	}
/**
 * 舞フレーム呼び出される描画メソッド
 */
	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		//背景描画
		d.drawImage(image, 0, 0);
		
		//操作指示
		d.setColor(Color.WHITE);
		d.setFontSize(15);
		d.drawString("xキー :　キャンセル   z　:　キー決定   矢印キー : 選択", 100, 460);
		
		//ポインターの描画
		drawSelectPointer(d);
		
		drawDesicive(d);
	}
	
	/**
	 * 意思確認の表示
	 * @param d
	 */
	private void drawDesicive(Drawer d){
		if(isSelecting){
			if(decisive){
				d.setColor(Color.RED);
				d.setFontSize(20);
				d.drawString("決定", 300, 400);
				d.setColor(Color.WHITE);
				d.drawString("キャンセル", 180, 400);
			}else{
				d.setColor(Color.WHITE);
				d.setFontSize(20);
				d.drawString("決定", 300, 400);
				d.setColor(Color.RED);
				d.drawString("キャンセル", 180, 400);
			}
		}
		
	}
	
	/**
	 * ポインターの横サイズ
	 */
	private final static int POINTER_WIDTH = 100;
	/**
	 * ポインターの縦サイズ
	 */
	private final static int POINTER_HEIGHT = 35;
	
	
	/**
	 * 選択してるステージを視覚的に分かるように描画する
	 * @param d
	 */
	private void drawSelectPointer(Drawer d){
		d.setColor(Color.GREEN);
		switch(state){
		case 1:
			d.drawRect(140, 145, POINTER_WIDTH, POINTER_HEIGHT);
			break;
		case 2:
			d.drawRect(275, 145, POINTER_WIDTH, POINTER_HEIGHT);
			break;
		case 3:
			d.drawRect(410, 145,POINTER_WIDTH, POINTER_HEIGHT);
			break;
		}
	}

}
	
