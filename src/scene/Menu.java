package scene;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import Player.Player;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
import densan.s.game.manager.Updatable;

/**
 * メニュー画面
 * @author tachibana
 *
 */
public class Menu implements Updatable{
/**
 * 背景画像のImage
 */
	private final static Image BACKGROUND = ImageLoader.load("image/Menu.png");
	/**
	 * ロゴのImage
	 */
	private final static Image ROGO = ImageLoader.load("image/rogo.png");
	/**
	 * ゲームマネージャーへの参照
	 */
	private final static GameManager gm = GameManager.getInstance();
	/**
	 * メニューの状態　後でenumとかstateとかに変更する可能性
	 */
	private int state=1;
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブif (KeyInput.isPressing(KeyEvent.VK_UP)) {
		
		if (KeyInput.isPress(KeyEvent.VK_DOWN)) {
			if(state<5&&state>0){
			state=5;	
			}
		}
		if (KeyInput.isPress(KeyEvent.VK_RIGHT)) {
			if(state<4&&state>0){
				state ++;
			}
		}
		if (KeyInput.isPress(KeyEvent.VK_LEFT)) {
			if(state<5&&state>1){
				state --;
			}
		}
		
		if(KeyInput.isPress(KeyEvent.VK_UP)){
			if(state==5){
				state= 1;
			}
		}
		
		if(KeyInput.isPress(KeyEvent.VK_Z)){
			switch(state){
			case 1:
				gm.setUpdatable(new StageSelect());
				break;
			case 2:
				gm.setUpdatable(new Shop());
			}
		}
	}

	int time = 0;
	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
	
		d.setFontSize(10);
		d.setColor(Color.BLACK);
		d.drawImage(BACKGROUND, 0, 0);
		d.drawRotationImage(ROGO, 100, 200, time*0.01);
		time ++;
		d.drawString("STAGESELECT",50,90);
		d.drawString("SHOP", 200, 90);
		d.drawString("DATA", 350, 90);
		
		d.drawString("zキーで決定",50,150);
		
		d.drawString(String.valueOf(state), 160, 160);
		
		d.setColor(Color.WHITE);
		d.setFontSize(15);
		d.drawString("xキー :　キャンセル     zキー　: 　決定      矢印キー : 選択", 100, 460);
		
		d.drawString(Player.getInstance().getMoney()+" G", 400, 400);
		
		
	}

}
