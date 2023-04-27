package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.vo.Member;

public interface MyPageService {

	/** 회원 탈퇴
	 * @param memberPw 
	 * @param member
	 * @return
	 */
	int secession(String memberPw, Member member);

	/** 비밀번호 변경
	 * @param member 
	 * @param currentPw
	 * @param newPw
	 * @return
	 */
	int changePw(Member member, String currentPw, String newPw);

}
