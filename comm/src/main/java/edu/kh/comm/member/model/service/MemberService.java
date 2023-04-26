package edu.kh.comm.member.model.service;

import java.util.List;

import edu.kh.comm.member.model.vo.Member;

/*	Service Interface를 사용하는 이유
 * 
 * 1. 프로젝트에 규칙성을 부여하기 위해서
 * 
 * 2. Spring AOP를 위해서 필요
 * 흩어진 관심사 : 소스코드상에서 계속 반복해서 사용되는 부분들
 * -> 유지보수를 어렵게 만든다(AspectX)
 * 
 * 3. 클래스 간의 결합도를 약화 시키기 위해서 -> 유지보수성 향상
 * 
 * 
 * */
public interface MemberService {
	
	// 모든 메서드가 추상 메서드 이다(묵시적으로 public abstract)
	// 모든 필드는 상수 이다		 (묵시적으로 public static final)
	
	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	public abstract Member login(Member inputMember);

	
	/** 이메일 중복 검사
	 * @param memberEmail
	 * @return
	 */
	public abstract int emailDupCheck(String memberEmail);


	/** 닉네임 중복 검사
	 * @param memberNickname
	 * @return
	 */
	public abstract int nicknameDupCheck(String memberNickname);


	/** 회원가입 서비스
	 * @param inputMember
	 * @return
	 */
	public abstract int signUp(Member inputMember);


	/** 회원 1명 조회
	 * @param memberEmail
	 * @return
	 */
	public abstract Member selectOne(String memberEmail);


	/** 회원 목록 조회(ajax)
	 * @return
	 */
	public abstract List<Member> selectAll(); 
	
	
	
	
	
	
	
	
}
