package service;

import dto.Member;

public interface NaverLoginService {

	Member naverLogin(String code,String state) throws Exception;
	
	
}
