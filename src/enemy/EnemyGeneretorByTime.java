package enemy;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
// */
//
//public class EnemyGeneretorByTime implements EnemyGeneretor{
//	/**
//	 * シングルトンgetInstanceの為のフィールド クラスを読み込んだ時にnewする
//	 */
//	public static  EnemyGeneretorByTime instance;
//	/**
//	 * 取得したjsonのrootデータ(時間で出現する敵のデータ)
//	 */
//	private JsonNode root;
//
//	  /**
//	   * 時間
//	   */
//	private int[] times;
//	  /**
//	   * x座標
//	   */
//	private int[] xps;
//	  /**
//	   * y座標
//	   */
//	private int[] yps;
//	
//	/**
//	 * 移動タイプ
//	 */
//	private int[] moveTypes;
//	
//	/**
//	 * エネミータイプ
//	 */
//	private int[] Enemytype;
//	
//	
//	  
//	/**
//	 * コンストラクター　singletonのためprivate
//	 * jsonのrootをフィールドに代入
//	 * @throws JsonProcessingException
//	 * @throws IOException
//	 */
//	public EnemyGeneretorByTime() {
//		//
//		//"TIME":int,"xp":int,"yp":int,"ENEMT_TYPE":int
//		
//		ObjectMapper mapper = new ObjectMapper();//マッパー
//		JsonNode json;
//		
//		 try {
//			 URL url=this.getClass().getResource("../resources/EnemyByTime.json");
//			root = mapper.readTree(url.getPath());
//		 }catch(FileNotFoundException e){
//			 System.out.println("ファイルが見つかりません");
//		} catch (JsonProcessingException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}//jsonのroot取得
//		//以下でgetとasTxtを使って整形してフィールド
//		
//	}
//	/**
//	 * getInstance
//	 * @throws IOException 
//	 * @throws JsonProcessingException 
//	 */
//	public static EnemyGeneretorByTime getInstance() throws JsonProcessingException, IOException{
//	if(instance==null){
//		instance = new EnemyGeneretorByTime();
//		}
//		return instance;
//		
//	}
//	
//	/**
//	 * genretorからenemyManagerのリストに
//	 * @param time　ゲーム開始してからの時間
//	 */
//	public void GenereteEnemy(int time,int listNumber){
//		ArrayList<Enemy> list = new ArrayList<Enemy>();
//		JsonNode node = root.get("ENEMY_LIST"+listNumber);
//		for(JsonNode n : node){
//			if(n.get("TIME").asInt()==time){
//				EnemyManager.getInstance().getList().add(new Enemy(n.get("xp").asDouble(), n.get( "yp").asDouble()));
//			}
//		}
//	}
//	/**
//	 * 
//	 * @param args
//	 * @throws JsonProcessingException
//	 * @throws IOException
//	 */
//	public static void main(String args[]) throws JsonProcessingException, IOException{
//		EnemyGeneretorByTime egbt =getInstance();
//	}
//}
//
