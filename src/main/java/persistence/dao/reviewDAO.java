package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.foodDTO;
import persistence.dto.reviewDTO;

import java.util.List;

public class reviewDAO {

    private final SqlSessionFactory sqlSessionFactory;

    public reviewDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    //맛집 리뷰 등록 메서드
    public void insertFoodReview(reviewDTO rdto){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("mapper.reviewMapper.insertFoodReview", rdto);
            session.commit();
        } catch (Exception e) {
            //실패할때 팝업을 여기다가
            session.rollback(); // 롤백 처리
            // 예외 처리 코드 작성
            // 예를 들어, 로그 출력 또는 다른 예외 처리 로직을 수행할 수 있습니다.
            e.printStackTrace(); // 예외 정보를 출력합니다.
            // 예외를 다시 던지거나, 특정 작업을 수행하도록 처리할 수 있습니다.
        } finally {
            session.close(); // 세션을 닫습니다.
        }

    }

    //관광지 리뷰 등록 메서드
    public void insertPlaylandReview(reviewDTO rdto) throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("mapper.reviewMapper.insertPlaylandReview", rdto);
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

    //맛집, 관광지의 리뷰데이터를 가져오는 메서드
    public List<reviewDTO> getFoodReview(int id){
        List<reviewDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.reviewMapper.getFoodReviews", id);
        }finally{
            session.close();
        }
        return list;
    }

    public List<reviewDTO> getPlaylandReview(int id){
        List<reviewDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.reviewMapper.getPlaylandReviews", id);
        }finally{
            session.close();
        }
        return list;
    }

}
