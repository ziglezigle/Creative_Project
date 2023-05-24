package persistence.dao;

import org.apache.ibatis.session.SqlSessionFactory;

public class userDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public userDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
