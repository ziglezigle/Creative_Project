package persistence.dao;

import creative_project.mainGUI;
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

    public void addFood(foodDTO fDto) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("mapper.foodMapper.insertFood",fDto);
            session.commit();
            mainGUI.alert("추가 성공!", "");
        }catch (Exception e){
            mainGUI.alert("추가 실패!", "");
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void updateFood(foodDTO fDto) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("mapper.foodMapper.",fDto);
            session.commit();
            mainGUI.alert("수정 성공!", "");
        }catch (Exception e){
            mainGUI.alert("수정 실패!", "");
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void deleteFood(foodDTO fDto) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("mapper.foodMapper.",fDto);
            session.commit();
            mainGUI.alert("수정 성공!", "");
        }catch (Exception e){
            mainGUI.alert("수정 실패!", "");
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }



}
