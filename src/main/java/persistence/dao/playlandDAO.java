package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.playLandDTO;
;import java.util.List;

public class playlandDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public playlandDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<playLandDTO> showPlayLand(){
        List<playLandDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.playlandMapper.selectPlayland");
        }finally {
            session.close();
        }
        return list;
    }

}
