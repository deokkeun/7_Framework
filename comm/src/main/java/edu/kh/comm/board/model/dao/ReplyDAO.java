package edu.kh.comm.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.board.model.vo.Reply;


@Repository
public class ReplyDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	public List<Reply> selectReplyList(int boardNo) {
		
		return sqlSession.selectList("replyMapper.selectReplyList", boardNo);
	}


	/** 댓글 등록
	 * @param replyInsert
	 * @return
	 */
	public int insert(Map<String, Object> map) {
		return sqlSession.insert("replyMapper.insert", map);
	}
	
}
