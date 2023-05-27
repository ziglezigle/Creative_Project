package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.foodDTO;

import java.util.List;

public class foodDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public foodDAO(SqlSessionFactory sqlSessionFactory) { this.sqlSessionFactory = sqlSessionFactory; }

    public List<foodDTO> showFood(foodDTO fdto){
        List<foodDTO> list = null;

        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.foodMapper.selectFood", fdto);
        }finally{
            session.close();
        }
        return list;
    }

    public List<foodDTO> showFood_review(foodDTO fdto){
        List<foodDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.foodMapper.selectFood", fdto);
        }finally{
            session.close();
        }
        return list;
    }


}
