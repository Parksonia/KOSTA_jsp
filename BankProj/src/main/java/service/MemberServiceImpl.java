package service;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void join(Member member) throws Exception {
		
		//selectmember로 중복 검증 추가해야함 
		MemberDAO memberdao = new MemberDAOImpl();
		Member smember = new Member();
		smember=memberdao.selectMember(member.getId());
		
		if(smember==null) {
			memberdao.insertMember(member);
		}else {
			throw new Exception("계정 중복");
		}

	}

	@Override
	public void login(String id, String password) throws Exception {
		MemberDAO memberdao = new MemberDAOImpl(); 
		Member lmember = memberdao.selectMember(id); // 찾은 멤버를 담을 객체
		
		if(lmember == null) throw new Exception("아이디 오류");
		if(!password.equals(lmember.getPassword())) throw new Exception("패스워드 오류"); 
		/*
		 * if(lmember.getId() !=id) { throw new Exception("아이디 오류"); }
		 * if(lmember.getPassword()!=password) { throw new Exception("패스워드 오류"); }
		 */
	}
	
	@Override
	public boolean checkDoubleId(String id) throws Exception {
		MemberDAO memberdao = new MemberDAOImpl();
		Member member = memberdao.selectMember(id);
		if(member==null) return false;
		
		return true;
	}

}
