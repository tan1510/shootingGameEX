package Ballet;

import java.awt.Color;

import Player.Player;
import densan.s.game.calc.Calc;
import densan.s.game.drawing.Drawer;


public class EnemyHomingBallet extends Ballet {


	public EnemyHomingBallet(double x, double y) {
		super(x,y,5,5);
		// TODO 自動生成されたコンストラクター・スタブ
		double rad= Calc.getRadian(this,Player.getInstance());
		this.setVector(30, rad);
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.BLUE);
		d.fillCircle(this.getX(), this.getY(),100);
		
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
		System.out.println("ballaetexist");
	}

	@Override
	public int getPower() {
		// TODO 自動生成されたメソッド・スタブ
		return 1;
	}

}
