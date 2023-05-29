package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.AdditionDTO;
import persistence.dto.reviewDTO;

import java.util.List;

public class AdditionDAO {
    private final SqlSessionFactory sqlSessionFactory;


    public AdditionDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insertAdditionRequirement(AdditionDTO additionDTO) throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("mapper.additionMapper.insertAdditionRequirement", additionDTO);
            session.commit();
        } catch (Exception e) {
            //실패할때 팝업을 여기다가
            session.rollback(); // 롤백 처리
            // 예외 처리 코드 작성
            // 예를 들어, 로그 출력 또는 다른 예외 처리 로직을 수행할 수 있습니다.
            throw new Exception();
        } finally {
            session.close(); // 세션을 닫습니다.
        }
    }
    public void requestDelete(String name){ // 리퀘스트 요청 완료후 삭제
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("mapper.additionMapper.deleteRequest",name);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }



    public List<AdditionDTO> viewRequirement(AdditionDTO sort){
        List<AdditionDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
           list = session.selectList("mapper.additionMapper.showRequest",sort);

        }  finally {
            session.close(); // 세션을 닫습니다.
        }
        return list;
    }


}
