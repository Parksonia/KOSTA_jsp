package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

public class NaverLoginServiceImpl implements NaverLoginService {

	private MemberDAO memberdao;
	public NaverLoginServiceImpl() {
		memberdao = new MemberDAOImpl();
	}
	@Override
	public Member naverLogin(String code, String state) throws Exception {
		String token = getNaverToken(code, state);
		Member member = getNaverUserInfo(token);
		Member smember = memberdao.selectMember(member.getId());
		
		if(smember == null) {
			memberdao.insertMember(member);
			return member; // 카카오가 아니라 일반 멤버
		}else {
			memberdao.updateMember(member);
			
		}
		return memberdao.selectMember(member.getId()); //새로 갱신된 걸 다시 셀렉해서 내보냄		
	}

	String getNaverToken(String code, String state) throws Exception {
		String client_id = "cN5KhLKCmZQ3KCGoyauD"; // naverdeveloper application에서 확인
		String client_secret = "3toSUvtkQ2";
		String redirectURI = URLEncoder.encode("http://localhost:8080/bank/naver", "utf-8");
		StringBuilder apiURL = new StringBuilder("https://nid.naver.com/oauth2.0/token?");

		// 요청변수정보 가져오기
		apiURL.append("grant_type=authorization_code");
		apiURL.append("&client_id=" + client_id);
		apiURL.append("&client_secret=" + client_secret);
		apiURL.append("&redirect_uri=" + redirectURI);
		apiURL.append("&code=" + code);
		apiURL.append("&state=" + state);

		URL url = new URL(apiURL.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // success
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else { // error
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder resBuilder = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			resBuilder.append(line);
		}

		br.close();
		conn.disconnect();

		System.out.println(resBuilder.toString());

		// resBuilder에서 token 만 파싱처리
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(resBuilder.toString());
		String token = (String) jsonObj.get("access_token");

		System.out.println(token);

		return token;

	}
	Member getNaverUserInfo(String token) throws Exception{
		Member member = null;

			URL url = new URL("https://openapi.naver.com/v1/nid/me");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "bearer "+token);
			
			int responserCode = conn.getResponseCode();
			
			BufferedReader br;
			if(responserCode >=200 &&responserCode<=300) { //success
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder resBuilder = new StringBuilder();
			String line;
			while((line=br.readLine())!=null) {
				resBuilder.append(line);
			}
			br.close();
			conn.disconnect();
			
			System.out.println(resBuilder.toString());
			member = new Member();
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(resBuilder.toString());
			JSONObject response =(JSONObject)jsonObj.get("response");
			
			String id = (String)response.get("id");
			String nickname=(String) response.get("nickname");
			String profile_image=(String) response.get("profile_image");
			String email=(String) response.get("email");
			String name=(String) response.get("name");
			
			member.setId(id);
			member.setNickname(nickname);
			member.setProfile_image(profile_image);
			member.setEmail(email);
			member.setName(name);
			
			System.out.println(member);
			
		return member;
	}
	
	
}
