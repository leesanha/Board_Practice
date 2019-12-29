package board.dao;

import board.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Board> getBoards() {
        final List<Board> board = mongoTemplate.find(new Query(), Board.class, "board");
        return board;
    }
}
