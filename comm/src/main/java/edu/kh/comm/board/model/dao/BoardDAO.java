package edu.kh.comm.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.board.model.vo.Board;
import edu.kh.comm.board.model.vo.BoardDetail;
import edu.kh.comm.board.model.vo.BoardImage;
import edu.kh.comm.board.model.vo.BoardType;
import edu.kh.comm.board.model.vo.Pagination;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시판 코드, 이름 조회
	 * @return
	 */
	public List<BoardType> selectBoardType() {

		return sqlSession.selectList("boardMapper.selectBoardType");
	}

	/** 특정 게시판의 전체 게시글 수 조회 DAO
	 * @param boardCode
	 * @return listCount
	 */
	public int getListCount(int boardCode) {
		return sqlSession.selectOne("boardMapper.getListCount", boardCode);
	}

	/** 게시판 목록 조회 DAO
	 * @param pagination
	 * @param boardCode
	 * @return boardList
	 */
	public List<Board> selectBoardList(Pagination pagination, int boardCode) {
		
		// RowBounds 객체(마이바티스)
		// - 전체 조회 결과에서
		// 몇 개의 행을 건너 뛰고 (offset)
		// 그 다음 몇개의 행만(limit) 조회할 것인지 지정
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectBoardList", boardCode, rowBounds);
	}

	/** 게시글 상세조회 DAO
	 * @param boardNo
	 * @return detail
	 */
	public BoardDetail selectBoardDetail(int boardNo) {
		
		return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNo);
	}

	/** 조회수 증가 DAO
	 * @param boardNo
	 * @return result
	 */
	public int updateReadCount(int boardNo) {
		
		return sqlSession.update("boardMapper.updateReadCount", boardNo);
	}

	/** 검색 조건에 맞는 게시글 목록의 전체 개수 조회 DAO
	 * @param paramMap
	 * @return listCount
	 */
	public int searchBoardList(Map<String, Object> paramMap) {
		
		return sqlSession.selectOne("boardMapper.searchListCount", paramMap);
	}

	/** 검색 조건에 맞는 게시글 목록 조회(페이징 처리 적용)
	 * @param paramMap
	 * @param pagination
	 * @return	boardList
	 */
	public List<Board> searchBoardList(Map<String, Object> paramMap, Pagination pagination) {
		
		int offset = ( pagination.getCurrentPage() - 1 ) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.searchBoardList", paramMap, rowBounds);
	}


	
	
	/** 게시글 삭제 서비스
	 * @param boardNo
	 * @return
	 */
	public int delete(int boardNo) {
		return sqlSession.update("boardMapper.delete", boardNo);
	}

	/** 게시글 삽입 DAO
	 * @param detail
	 * @return
	 */
	public int insetBoard(BoardDetail detail) {
		
		int result = sqlSession.insert("boardMapper.insertBoard", detail); // 0 또는 1
		
		if(result > 0) result = detail.getBoardNo();
		
		// 게시글 삽입 성공 시 <selectKey> 태그를 이용해 세팅된 boardBo 값을 반환함

		return result;
	}

	/** 게시글 이미지 삽입(리스트) DAO
	 * @param boardImageList
	 * @return result
	 */
	public int insertBoardImageList(List<BoardImage> boardImageList) {
		return sqlSession.insert("boardMapper.insertBoardImageList", boardImageList);
	}

	/** 게시글 수정 DAO
	 * @param detail
	 * @return
	 */
	public int updateBoard(BoardDetail detail) {

		return sqlSession.update("boardMapper.updateBoard", detail);
	}

	/** 게시글 이미지 삭제 
	 * @param map
	 * @return
	 */
	public int deleteBoardImage(Map<String, Object> map) {

		return sqlSession.delete("boardMapper.deleteBoardImage", map);
	}

	/** 게시글 이미지 1개 수정
	 * @param img
	 * @return
	 */
	public int updateBoardImage(BoardImage img) {

		return sqlSession.update("boardMapper.updateBoardImage", img);
	}

	/** 게시글 이미지 1개 삽입 
	 * @param img
	 * @return
	 */
	public int insertBoardImageList(BoardImage img) {
		return sqlSession.insert("boardMapper.insertBoardImage", img);
	}

	

	
	
}
