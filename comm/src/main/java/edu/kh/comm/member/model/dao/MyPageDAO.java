package edu.kh.comm.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.member.model.vo.Member;

@Repository
public class MyPageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 회원탈퇴 비밀번호 일치 확인
	 * @param member
	 * @return
	 */
	public String secession(Member member) {
		return sqlSession.selectOne("myPageMapper.passwordCheck", member);
	}


	/** 회원탈퇴 Secession Y로 변경
	 * @param member
	 * @return
	 */
	public int updateSecession(Member member) {
		return sqlSession.update("myPageMapper.updateSecession", member);
	}

	
	/** 비밀번호 변경
	 * @param paramMap
	 * @return
	 */
	public int changePw(Map<String, Object> paramMap) {
		return sqlSession.update("myPageMapper.changePw", paramMap);
	}



	/** 회원 정보 수정 DAO
	 * @param paramMap
	 * @return result
	 */
	public int updateInfo(Map<String, Object> paramMap) {

		return sqlSession.update("myPageMapper.updateInfo", paramMap);
	}


	/** 현재 로그인한 회원의 암호화된 비밀번호 조회 DAO
	 * @param memberNo
	 * @return
	 */
	public String selectEncPw(int memberNo) {
		
		return sqlSession.selectOne("myPageMapper.selectEncPw", memberNo);
	}


	/** 회원 탈퇴 DAO
	 * @param memberNo
	 * @return
	 */
	public int secession(int memberNo) {

		return sqlSession.update("myPageMapper.secession", memberNo);
	}


	/** 프로필 이미지 수정
	 * @param map
	 * @return result
	 */
	public int updateProfile(Map<String, Object> map) {
		
		return sqlSession.update("myPageMapper.updateProfile", map);
	}
	
	
	
	
	
	
	
}
