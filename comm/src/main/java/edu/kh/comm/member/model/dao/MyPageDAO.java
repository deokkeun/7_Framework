package edu.kh.comm.member.model.dao;

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
	 * @param member
	 * @return
	 */
	public int changePw(Member member) {
		return sqlSession.update("myPageMapper.changePw", member);
	}

	
	
	
	
	
	
	
}
