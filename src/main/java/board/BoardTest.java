package board;

import board.vo.Board;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

public class BoardTest {
    public static void main(String[] args) {
        MongoTemplate mongo;
        Board b = new Board( "bbb", "ccc", "lee", new Date());

        String mongoContextPath = "/mongoContext.xml";
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);

        mongo = (MongoTemplate) ctx.getBean("mongoTemplate");

//        mongo.insert(b);

        List<Board> list = mongo.find(new Query(), Board.class, "board");
        for(Board bb : list){
            System.out.println(bb);
        }
    }
}
