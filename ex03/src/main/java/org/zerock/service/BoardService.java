package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
    
    int register(BoardVO board);
    
    BoardVO get(int bno);
    
    int modify(BoardVO board);
    
    int remove(int bno);

    List<BoardVO> getList();
    
    List<BoardVO> getList(Criteria cri);
    
    int getTotal(Criteria cri);
}
