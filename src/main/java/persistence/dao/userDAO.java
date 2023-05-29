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
            e.printStackTrace(); // 예외 정보를 출력합니다.
        } finally {
            session.close(); // 세션을 닫습니다.
        }
    }

    public boolean idTest(String logId) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.selectOne("mapper.userMapper.checkId", logId);
        return count > 0;
    }
    public boolean pwTest(String logId,String logPw) {
        SqlSession session = sqlSessionFactory.openSession();
        String pw = session.selectOne("mapper.userMapper.checkPw", logId);
        if(pw.equals(logPw)){
            return true;
        }
        else {
            return false;
        }
    }
    public int getAuth(String logId){
        SqlSession session = sqlSessionFactory.openSession();
        int auth = session.selectOne("mapper.userMapper.getAuth", logId);
        return auth;
    }

    public int getPk(String logId){
        SqlSession session = sqlSessionFactory.openSession();
        int pk = session.selectOne("mapper.userMapper.checkpk", logId);
        return pk;
    }

    public void test() {
        SqlSession session = sqlSessionFactory.openSession();
        String pw = session.selectOne("mapper.userMapper.checkPw", "wpdldkf123");
        if(pw.equals("wpdldkf1")){
            System.out.println("비밀번호가 맞음");
        }
        else {
            System.out.println("비밀번호가틀림");
            System.out.println(pw);
        }
    }

}
