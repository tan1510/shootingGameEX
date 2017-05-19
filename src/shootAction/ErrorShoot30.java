package shootAction;

import java.util.Random;

public class ErrorShoot30 implements ShootAction{

	@Override
	public void shoot() {
		// TODO 自動生成されたメソッド・スタブ
		Random r = new Random();
		if(r.nextInt(10)<3){
			
		}
	}

	@Override
	public int getWaitTime() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}