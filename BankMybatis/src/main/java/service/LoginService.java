package service;

import dto.Member;

public interface LoginService {

		Member kakaoLogin(String code) throws Exception;
	
}
