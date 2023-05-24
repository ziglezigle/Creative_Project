package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.userDTO;

public class userDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public userDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void SignUp(userDTO userDTO) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("mapper.userMapper.SignUp", userDTO);
            session.commit();
        } catch (Exception e) {
            session.rollback(); // 롤백 처리
            // 예외 처리 코드 작성
            // 예를 들어, 로그 출력 또는 다른 예외 처리 로직을 수행할 수 있습니다.
            e.printStackTrace(); // 예외 정보를 출력합니다.
            // 예외를 다시 던지거나, 특정 작업을 수행하도록 처리할 수 있습니다.
        } finally {
            session.close(); // 세션을 닫습니다.
        }
    }

}
