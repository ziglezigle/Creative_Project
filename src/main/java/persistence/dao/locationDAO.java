package persistence.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.locationDTO;

public class locationDAO {

    private final SqlSessionFactory sqlSessionFactory;


    public locationDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public locationDTO getNxNyCode(String Do, String Si){

        SqlSession session = sqlSessionFactory.openSession();

        locationDTO dto = new locationDTO(Do, Si);
        try{
            dto = session.selectOne("mapper.locationMapper.getNxNyCode", dto);
        }finally {
            session.close();
        }

        return dto;
    }

//    public String getCode(String Do, String Si){
//
//        locationDTO dto = new locationDTO();
//        dto.setDo(Do);
//        dto.setSi(Si);
//
//        SqlSession session = sqlSessionFactory.openSession();
//
//        try{
//             dto = session.selectOne("mapper.locationMapper.getCode", dto);
//        }finally {
//            session.close();
//        }
//
//        return dto.getCode();
//    }

}
