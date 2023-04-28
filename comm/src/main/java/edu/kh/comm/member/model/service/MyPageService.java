package edu.kh.comm.member.model.service;

import java.io.IOException;
import java.util.Map;

import edu.kh.comm.member.model.vo.Member;

public interface MyPageService {


//	/** 비밀번호 변경
//	 * @param member 
//	 * @param currentPw
//	 * @param newPw
//	 * @return
//	 */
//	int changePw(Member member, String currentPw, String newPw);

	/** 회원 정보 수정 
	 * @param paramMap
	 * @return
	 */
	int updateInfo(Map<String, Object> paramMap);

	/** 비밀번호 변경
	 * @param paramMap
	 * @return
	 */
	int changePw(Map<String, Object> paramMap);

	
	
	/** 회원 탈퇴
	 * @param loginMember
	 * @return
	 */
	int secession(Member loginMember);

	
	

	/** 프로필 이미지 수정 서비스
	 * @param map
	 * @return result
	 */
	int updateProfile(Map<String, Object> map) throws IOException;

	
	
	

}
