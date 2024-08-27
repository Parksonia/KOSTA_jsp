package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dto.Member;

public class LoginServiceImpl implements LoginService {

	@Override
	public void kakaoLogin(String code) throws Exception {

		String token= getKakaoToken(code);
		//받은 토큰 가지고 사용자 정보를 요청
		Member member = getKakaoUserInfo(token);
		//1.member의 id로 database에서 조회
		//1-1. db에 없으면 member insert
		//1-2. 로그인 처리. 즉, session에 로그인 정보 넣기 
		
		
		
	}

	//토큰으로 받는 방법(post방식임)
	//https://kauth.kakao.com/oauth/token
	String getKakaoToken(String code) throws Exception{
		
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(tokenUrl);
		HttpURLConnection conn =(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true); // 출력 스트림 활성화
		
		/*토큰을 받아오기 위해서  필수항목을 다 가져와야함 */
		StringBuilder param = new StringBuilder();
		param.append("grant_type=authorization_code"); //authorization_code로 고정
		param.append("&client_id=");
		param.append("&redirect_uri=http://localhost:8080/social/kakao");
		param.append("&code="+code);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(param.toString());
		bw.flush(); // 출력
		
		//응답
		BufferedReader br;
		
		
		int resultCode = conn.getResponseCode(); //정상인지 아닌지 에러 여부
		if(resultCode>=200 && resultCode<=300) { // 정상
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}else {// 비정상
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				
		}
		StringBuilder resultBuilder = new StringBuilder();
		String line;
		while((line= br.readLine())!= null) {
			resultBuilder.append(line); // json형태의 문자열 
			
		}
		//System.out.println(resultBuilder.toString());
		br.close();
		conn.disconnect();
		
		JSONParser parser = new JSONParser(); // tomcat꺼가 아니라 추가한 json.simple.jar lib
		JSONObject tokenobj = (JSONObject) parser.parse(resultBuilder.toString());
		String token = (String)tokenobj.get("access_token"); //전체에서 access_token만 가져오는 방법 
		
		return token;
	}
	//사용자 정보 가져오기 (get/post방식 모두 가능)
	//https://kapi.kakao.com/v2/user/me
	Member getKakaoUserInfo(String token) throws Exception{
		String userUrl ="https://kapi.kakao.com/v2/user/me";
		URL url = new URL(userUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET"); // post도 가능
		
		//헤더 필수사항 :Content-type,Authorization
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setRequestProperty("Authorization", "Bearer "+token);
		
		BufferedReader br ;
		int resultCode = conn.getResponseCode();
		if(resultCode>=200 && resultCode<=300) { // 정상
			br = new BufferedReader(new InputStreamReader(conn.getInputStream())); //json->inputstream->text로 
		}else {// 비정상
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				
		}
		StringBuilder builder = new StringBuilder();
		String line;
		while((line=br.readLine())!=null) {
			builder.append(line);
			
		}
		br.close();
		conn.disconnect();
		System.out.println(builder.toString());

		JSONParser parser = new JSONParser();
		parser.parse(builder.toString());
		JSONObject userObj = (JSONObject)parser.parse(builder.toString());
		Long id = (Long)userObj.get("id");
		JSONObject properties = (JSONObject)userObj.get("properties"); //
		String nickname = (String)properties.get("nickname");
		String profile_image = (String)properties.get("profile_image");
	
		Member member = new Member();
		member.setId(id+""); //String으로 바꿈("")
		member.setName(nickname);
		member.setProfile_image(profile_image);
	
		return member;
	}
	
}
