package edu.kh.comm.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MyPageDAO;
import edu.kh.comm.member.model.vo.Member;

@Service
public class MyPageServiceImpl implements MyPageService{

	private Logger logger = LoggerFactory.getLogger(MyPageServiceImpl.class);
	
	@Autowired
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;


	/** 회원 탈퇴
	 *
	 */
	@Override
	public int secession(String memberPw, Member member) {

		logger.debug("ServiceImpl member : " + member);
		
		logger.debug(memberPw);
		
		logger.debug("회원탈퇴 DAO전 : " + memberPw);
		String memPw = dao.secession(member);
		logger.debug("회원탈퇴 DAO후 : " + memberPw + " / " + memPw);
		
		int result = 0;
		
		if(bcrypt.matches(memberPw, memPw)) {
			result = dao.updateSecession(member);
		}
		return result;
	}


	/** 비밀번호 변경
	 *
	 */
	@Override
	public int changePw(Member member, String currentPw, String newPw) {

		String newPassword = bcrypt.encode(newPw);
		
		String memPw = dao.secession(member);
		
		logger.debug("비밀번호 변경 서비스 : " + currentPw);
		logger.debug("비밀번호 변경 서비스 : " + memPw);
		logger.debug("비밀번호 변경 서비스 : " + newPassword);
		
		int result = 0;
		
		if(bcrypt.matches(currentPw, memPw)) {
			member.setMemberPw(newPassword);
			logger.debug("비밀번호 일치 : " + member.getMemberPw());
			result = dao.changePw(member);
		}
		
		return result;
	}


	/** 회원정보 수정
	 *
	 */
	@Override
	public int updateInfo(Member loginMember) {
		return dao.updateInfo(loginMember);
	}


	
	
	
	
	
	
	
}
