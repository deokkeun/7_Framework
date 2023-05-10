package edu.kh.comm.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.comm.board.model.vo.Reply;

public interface ReplyService {

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	List<Reply> selectReplyList(int boardNo);


	/** 댓글 등록
	 * @param replyInsert
	 * @return
	 */
	int insert(Map<String, Object> map);
	
	
}
