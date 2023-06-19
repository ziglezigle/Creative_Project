package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.memoDTO;

import java.util.List;

public class memoDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public memoDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<memoDTO> showMemo() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("mapper.memoMapper.selectMemo");
        }
    }


    public void updateMemo(memoDTO memo) {
        SqlSession session = sqlSessionFactory.openSession();

        try  {
            session.update("mapper.memoMapper.updateMemo", memo);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }
    public void addMemo(memoDTO dto){
        SqlSession session = sqlSessionFactory.openSession();

        try{
            session.insert("mapper.memoMapper.addMemo", dto);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    public void deleteMemo(int id) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("mapper.memoMapper.deleteMemo", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }

}
