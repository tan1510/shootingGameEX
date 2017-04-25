package json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {

	   public static void main(String[] args)throws IOException{
		   //
		   ObjectMapper mapper = new ObjectMapper();
		   JsonNode root = mapper.readTree(new File("src/test.json"));
		   System.out.println("aa");
		   System.out.println(root);
		   String member_name = root.get("メンバー表").get(1).get("年齢").asText();
		   System.out.println(member_name);

	   }
}

/*

{
    "メンバー表":[
        {
            "氏名":"田中太郎",
            "年齢":18
        },
        {
            "氏名":"山田花子",
            "年齢":19
        }
    ]
}


*/