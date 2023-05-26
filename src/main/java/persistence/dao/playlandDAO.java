package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.foodDTO;
import persistence.dto.playLandDTO;
;import java.util.List;

public class playlandDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public playlandDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<playLandDTO> showPlayLand(playLandDTO pldto){
        List<playLandDTO> list = null;

        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.playlandMapper.selectPlayland", pldto);
        }finally {
            session.close();
        }
        return list;
    }

    public List<playLandDTO> showPlayLand_review(playLandDTO pldto){
        List<playLandDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.playlandMapper.selectPlayland", pldto);
        }finally{
            session.close();
        }
        return list;
    }

}

//
//    public List<playLandDTO> searchPlayLand(){
//        List<playLandDTO> list = null;
//
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//            list = session.selectList("mapper.playlandMapper.searchPlayland");
//        }finally {
//            session.close();
//        }
//        return list;
//    }
//
//    public List<playLandDTO> searchPlayLandById(int id){
//        playLandDTO tmp = new playLandDTO();
//        tmp.setId(id);
//
//        List<playLandDTO> list = null;
//        SqlSession session = sqlSessionFactory.openSession();
//        try{
//            list = session.selectList("mapper.playlandMapper.select_by_id", id);
//        }finally {
//            session.close();
//        }
//        return list;
//    }
