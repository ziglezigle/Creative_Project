package persistence.dao;

import creative_project.mainGUI;
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

    public List<playLandDTO> showPlayLand(playLandDTO pldto) {
        List<playLandDTO> list = null;

        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.playlandMapper.selectPlayland", pldto);
        } finally {
            session.close();
        }
        return list;
    }

    public List<playLandDTO> showPlayLand_review(playLandDTO pldto) {
        List<playLandDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.playlandMapper.selectPlayland", pldto);
        } finally {
            session.close();
        }
        return list;
    }
    public void addPlayLand(playLandDTO playLandDTODto) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("mapper.playlandMapper.insertPlayLand", playLandDTODto);
            session.commit();
            mainGUI.alert("추가 성공!", "");
        } catch (Exception e) {
            mainGUI.alert("추가 실패!", "");
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public List<playLandDTO> spotID_로_정보_찾기(int id) {
        List<playLandDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.playlandMapper.selectSpotBySpotId", id);
        } finally {
            session.close();
        }
        return list;
    }

    public int 컬럼정보로_spot_id찾기(playLandDTO playLandDTO) {

        SqlSession session = sqlSessionFactory.openSession();
        int i;

        try {
            i = session.selectOne("mapper.playlandMapper.selectSpotId", playLandDTO);
        } finally {
            session.close();
        }

        return i;
    }
    public void updatePlayLand(playLandDTO playLand) {
        SqlSession session = sqlSessionFactory.openSession();
        try  {
            session.update("mapper.playlandMapper.updatePlayLand", playLand);
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

    public void deleteSpot(int id) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("mapper.playlandMapper.deletePlayland",id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
