package persistence.dao;

import creative_project.mainGUI;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.requireAddDTO;

public class requireAddDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public requireAddDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public void addRequire(requireAddDTO dto){
        SqlSession session = sqlSessionFactory.openSession();

        try{
            session.insert("mapper.requireAddMapper.addRequire", dto);
            session.commit();
            mainGUI.alert("추가 성공!", "");
        }catch (Exception e){
            session.rollback();
            mainGUI.alert("추가 실패!", "");
        }finally {
            session.close();
        }
    }


}
