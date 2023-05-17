import persistence.MyBatisConnectionFactory;
import persistence.dao.playlandDAO;
import persistence.dto.playLandDTO;

import java.util.List;

public class test {

    public static void main(String args[]){

        playLandDTO playLandDTO = new playLandDTO();
        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());


        List<persistence.dto.playLandDTO> posts = playlandDAO.showPlayLand();
       posts.stream().forEach(p ->System.out.println(p.toString()));

    }


}
