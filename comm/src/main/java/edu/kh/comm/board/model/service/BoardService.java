package edu.kh.comm.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.comm.board.model.vo.BoardDetail;
import edu.kh.comm.board.model.vo.BoardType;
import edu.kh.comm.member.model.vo.Member;

public interface BoardService {

	/** 게시판 코드, 이름 조회
	 * @return
	 */
	List<BoardType> selectBoardType();

	/** 게시글 목록 조회 서비스
	 * @param cp
	 * @param boardCode
	 * @return map
	 */
	Map<String, Object> selectBoardList(int cp, int boardCode);

	/** 게시글 상세 조회 서비스
	 * @param boardNo
	 * @return
	 */
	BoardDetail selectBoardDetail(int boardNo);

	/** 조회수 증가 서비스
	 * @param boardNo
	 * @return result
	 */
	int updateReadCount(int boardNo);

	/** 검색 게시글 목록 조회 서비스
	 * @param paramMap 
	 * @return map
	 */
	Map<String, Object> searchBoardList(Map<String, Object> paramMap);

	/** 게시글 삭제 서비스
	 * @param boardNo
	 * @return
	 */
	int delete(int boardNo);

	/** 게시글 등록(insert)
	 * @param paramMap
	 * @return
	 */
	int insertBoard(Map<String, Object> paramMap);

}
