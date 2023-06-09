package edu.kh.comm.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.comm.board.model.dao.ReplyDAO;
import edu.kh.comm.board.model.vo.Reply;
import edu.kh.comm.common.Util;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDAO dao;
	
	/** 댓글 목록 조회
	 *
	 */
	@Override
	public List<Reply> selectReplyList(int boardNo) {
		return dao.selectReplyList(boardNo);
	}

	
	

	/** 댓글 등록
	 *
	 */
	@Override
	public int insert(Reply reply) {
		
		// XSS, 개행문자 처리
		reply.setReplyContent(Util.XSSHandling(reply.getReplyContent()));
		reply.setReplyContent(Util.newLineHandling(reply.getReplyContent()));
		
		return dao.insert(reply);
	}

	
	
//	/** 댓글등록
//	 *
//	 */
//	@Override
//	public int insert(Map<String, Object> map) {
//		return dao.insert(map);
//	}


	/** 댓글 수정
	 *
	 */
	@Override
	public int update(Map<String, Object> map) {
		return dao.update(map);
	}

	/** 댓글 삭제
	 *
	 */
	@Override
	public int delete(Map<String, Object> map) {
		return dao.delete(map);
	}

	


	
	
	


}
