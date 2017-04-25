package enemy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//"TIME":int,"xp":int,"yp":int,"ENEMT_TYPE":int
/**
 * あとでenum
 * 時間経過に応じてエネミーを生成する
 * @author tachibana
 *
 */
public class EnemyGeneretorByTime implements EnemyGeneretor{
	/**
	 * シングルトンgetInstanceの為のフィールド クラスを読み込んだ時にnewする
	 */
	private  EnemyGeneretorByTime gener = new EnemyGeneretorByTime();
	/**
	 * 取得したjsonのrootデータ(時間で出現する敵のデータ)
	 */
	private JsonNode root;

	  /**
	   * 時間
	   */
	private int[] times;
	  /**
	   * x座標
	   */
	private int[] xps;
	  /**
	   * y座標
	   */
	private int[] yps;
	
	/**
	 * 移動タイプ
	 */
	private int[] moveTypes;
	
	/**
	 * エネミータイプ
	 */
	private int[] Enemytype;
	  
	/**
	 * コンストラクター　singletonのためprivate
	 * jsonのrootをフィールドに代入
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	private EnemyGeneretorByTime() throws JsonProcessingException, IOException{
		//
		//"TIME":int,"xp":int,"yp":int,"ENEMT_TYPE":int
		
		ObjectMapper mapper = new ObjectMapper();//マッパー
		JsonNode root = mapper.readTree(new File("Resources/EnemyByTime.json"));//jsonのroot取得
		//以下でgetとasTxtを使って整形してフィールド
		
	}
	/**
	 * getInstance
	 * @param int 取得するリストのナンバー 
	 * @return インスタンス
	 */
	public EnemyGeneretor getInstance(int listNumber){
		int size = root.get("ENEMY_LIST1").size();
				
		//要修正
		for(int m =0; m<size;m++){
			JsonNode jsonNode = root.get("ENEMY_LIST1").get(m);
			for(JsonNode n : jsonNode){
			
			
			}
		}
		return gener;
	}
	
	/**
	 * 
	 * @param time　ゲーム開始してからの時間
	 * @return ArrayList
	 */
	public ArrayList<Enemy> getGenereteEnemyList(int time){
		return null;
	}
}

