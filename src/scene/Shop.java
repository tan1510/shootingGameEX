package scene;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;

import Player.Player;
import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.input.KeyInput;
import densan.s.game.manager.GameManager;
import densan.s.game.manager.Updatable;

/**
 * 
 * @author tachibana
 *
 */
public class Shop implements Updatable{
	/**
	 * 
	 */
	private static final Image bgimage = ImageLoader.load("image/SHOP.png");
	/**
	 * 
	 */
	private static final Player p = Player.getInstance();
	/**
	 * パワーのレベルアップ　1→2　1000g
	 */
	private static final int POWERUPCOST_FIRST = 1000;
	/**
	 * パワーのレベルアップ　1→2　1000g
	 */
	private static final int POWERUPCOST_SECOND = 2000;
	/**
	 * パワーのレベルアップ　1→2　1000g
	 */
	private static final int POWERUPCOST_THIRD = 4000;

	private boolean buyfailed =false;
	/**
	 * 
	 */
	//private static final int POWER_UP
	/**
	 * 選択状態を表す enum での実装も考える
	 */
	private int state = 2;
	private int lastState = 2;
	
	public Shop() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 * 
	 */
	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		if (KeyInput.isPress(KeyEvent.VK_DOWN)){
			if(state<=6)
			state++;
	
		}else if(KeyInput.isPress(KeyEvent.VK_UP)){
			if(state>2)
				state--;
			
		}else if (KeyInput.isPress(KeyEvent.VK_RIGHT)){
				if(state==0)
				state=1;
		}else if (KeyInput.isPress(KeyEvent.VK_LEFT)){
			if(state==1)
			state=0;
		}else if(KeyInput.isPress(KeyEvent.VK_Z)){
			if(state>1&&state<7){
				lastState = state;
				state = 0;
			}
			else if(state==0){
				state = lastState;
			}
			else if(state ==1){
				switch(lastState){
				case 2:
					buyPowerUP();
					state = lastState;
					break;
				case 3:
					buySpeedUp();
				
				}
			}
		}else if(KeyInput.isPress(KeyEvent.VK_X)){
			if(state>-1&&state<2){
				state = lastState;
			}else{
				GameManager.getInstance().setUpdatable(new Menu());
			}
		}
	}


	@Override
	/**
	 * 
	 */
	public void draw(Drawer d) {
		d.drawImage(bgimage, 0, 0);
		d.setColor(Color.BLACK);
		d.drawString("G : "+ p.getMoney(), 300,30 );
		switch(state){
		case 0:
			d.setColor(Color.RED);
			d.drawString("キャンセル",100, 370);
			d.setColor(Color.BLACK);
			d.drawString("購入", 400,370 );
			drawbystate(d, lastState);
			break;
		case 1:
			d.drawString("キャンセル",100, 370);
			d.setColor(Color.RED);
			d.drawString("購入", 400,370 );
			d.setColor(Color.BLACK);
			drawbystate(d, lastState);
			break;
		
		
			default :
				drawbystate(d, state);
			break;
			}
		
		
	}
/**
 * 
 * @param d,state
 */
	public void drawbystate(Drawer d,int state){
		switch (state) {
		case 2:
			d.setFontSize(40);
			d.drawString("Power UP", 150, 240);
			d.setFontSize(20);
			switch(p.getPower()){
			case 1:
				d.drawString("レベル1→レベル2:1000G", 100, 340);
				break;
			case 2:
				d.drawString("レベル2→レベル3:2000G", 100, 340);
				break;
			case 3:
				d.drawString("レベル3→レベル4:4000G", 100, 340);
				break;
			default:
					d.drawString("レベルMAX     :0G", 100, 340);
			}
			break;
		
		case 3:
			d.setFontSize(40);
			d.drawString("SPEED UP", 150, 240);
			d.setFontSize(20);
			switch(p.getSPEED()){
			//途中
			case 1:
			break;
			}
		}
		
		
		if(buyfailed){
			d.setColor(Color.RED);
			d.setFontSize(20);
			d.drawString("購入できませんでした。", 100, 400);
		}
		
	}
	/**
	 * 
	 */
	private void buyPowerUP(){
		switch (p.getPower()) {
		case 1:
			if(p.getMoney()>=POWERUPCOST_FIRST){
				p.setPower(2);
				p.setMoney(p.getMoney()-POWERUPCOST_FIRST);
			}else{
				buyfailed=true;
			}
			break;
		case 2:
			if(p.getMoney()>=POWERUPCOST_SECOND){
				p.setPower(3);
				p.setMoney(p.getMoney()-POWERUPCOST_SECOND);
			}else{
				buyfailed=true;
			}
			break;
		case 3:
			if(p.getMoney()>=POWERUPCOST_THIRD){
				p.setPower(5);
				p.setMoney(p.getMoney()-POWERUPCOST_THIRD);
			}else{
				buyfailed=true;
			}
		}
		
	}
	private void buySpeedUp() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
