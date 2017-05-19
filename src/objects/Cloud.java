package objects;
import java.awt.Image;

import densan.s.game.drawing.Drawer;
import densan.s.game.image.ImageLoader;
import densan.s.game.object.GameObjectBase;


public class Cloud extends GameObjectBase{

	private static final Image image = ImageLoader.load("image/cloud.png");
	public Cloud(double x, double y) {
		super(x, y, 10, 10);
		// TODO 自動生成されたコンストラクター・スタブ
		setVector(2,Math.PI);
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.drawImage(image, getX(), getY());
		
	}

}
