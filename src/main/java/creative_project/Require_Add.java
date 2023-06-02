package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.AdditionDAO;
import persistence.dto.AdditionDTO;

public class Require_Add {

    @FXML
    private Button btn_add_list;

    @FXML
    private ComboBox cb_information_Do;

    @FXML
    private ComboBox cb_information_Si;

    @FXML
    private ComboBox cb_choose_list;

    @FXML
    private TextArea ta_require;

    @FXML
    private TextField tf_nameOf_there;

    @FXML
    void add_require_list(ActionEvent event) {
        AdditionDTO additionDTO = new AdditionDTO();
        AdditionDAO additionDAO = new AdditionDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        String name = tf_nameOf_there.getText();
        if(name == ""){
            name = null;
        }else {

        }
        String sort = (String)cb_choose_list.getValue();
        String state = (String)cb_information_Do.getValue();
        String city = (String)cb_information_Si.getValue();
        String content = ta_require.getText();

        additionDTO.setSort(sort);
        additionDTO.setState(state);
        additionDTO.setName(name);
        additionDTO.setCity(city);
        additionDTO.setContent(content);

        try{
            additionDAO.insertAdditionRequirement(additionDTO);
            mainGUI.alert("등록 성공", "정상적으로 등록되었습니다");
        }catch(Exception e){
            mainGUI.alert("등록 실패", "");

        }
        //resetPage(); //리뷰화면 초기화

    }



    @FXML
    void setSiInfo(ActionEvent event){
        ROKArea.handleDo((String)cb_information_Do.getValue(), cb_information_Si);
    }

}
