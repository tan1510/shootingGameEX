package enemy;

import java.awt.Image;
import java.util.List;

import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;

public class StageConstoracter3 implements StageConstoracter {
	private List<Enemy> manager = EnemyManager.getInstance().getList();
	private final static Image BGIMAGE1 = ImageLoader.load("image/stage3_1.png");
	private final static Image BGIMAGE2 = ImageLoader.load("image/stage3_2.png");
	private int time = 0;
	public StageConstoracter3() {
		// TODO Auto-generated constructor stub
		manager.isEmpty();

	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		switch(time){
		case 0: 
	//		manager.add(new Enemy_BallType1(600, 400));
		//	manager.add(new Enemy_BallType1(640, 220));
			manager.add(new Enemy_BallType3());
			break;
		}
		time++;
		
		if(bgcount1>640){
			bgcount1=0;
		}else{
		bgcount1++;
		}
		
		if(bgcount2>640){
			bgcount2=0;
		}else{
		bgcount2++;
		}
	}

	private int bgcount1 = 0;
	private int bgcount2 = 0;
	@Override
	public void draw(Drawer d) {
		// TODO Auto-generated method stub
		d.drawImage(BGIMAGE1, 0-bgcount1*2, 0);
		d.drawImage(BGIMAGE2, 1280-bgcount2*2, 0);
		
	}

}
