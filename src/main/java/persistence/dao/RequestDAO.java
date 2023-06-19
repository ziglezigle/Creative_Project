package persistence.dao;

import creative_project.mainGUI;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dto.RequestDTO;


import java.util.List;

public class RequestDAO {

    private  final SqlSessionFactory sqlSessionFactory;

    public RequestDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    //맛집관련 요청 받아오는 메서드
    public List<RequestDTO> getRequireFood(){
        List<RequestDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.requestMapper.showRequestFood");
        }finally{
            session.close();
        }
        return list;
    }

    //관광지 관련 요청 받아오는 메서드
    public List<RequestDTO> getRequireSpot(){
        List<RequestDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.requestMapper.showRequestSpot");
        }finally{
            session.close();
        }
        return list;
    }



    public void DeleteFood(int id){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("mapper.requestMapper.deleteRequestFood",id);

            session.commit();
            mainGUI.alert("음식점 삭제 성공!", "");
        } catch (Exception e){
            mainGUI.alert("음식점 삭제 실패!", "");
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void DeleteSpot(int id){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("mapper.requestMapper.deleteRequestSpot",id);

            session.commit();
            mainGUI.alert("관광지 삭제 성공!", "");
        } catch (Exception e){
            mainGUI.alert("관광지 삭제 실패!", "");
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void insertRequestFood(RequestDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(dto.toString());
        try{
            session.insert("mapper.requestMapper.insertRequestFood", dto);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    public void insertRequestPlayland(RequestDTO dto){
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(dto.toString());

        try{
            session.insert("mapper.requestMapper.insertRequestPlayland", dto);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }


}
