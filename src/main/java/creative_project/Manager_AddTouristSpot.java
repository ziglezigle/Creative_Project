package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import persistence.MyBatisConnectionFactory;
import persistence.dao.AdditionDAO;
import persistence.dao.playlandDAO;
import persistence.dto.playLandDTO;

public class Manager_AddTouristSpot {

    @FXML
    private Button bt_touristSpot_register;
    //관광지 추가 버튼

    @FXML
    private ComboBox<?> cb_select_Do;
    //도 선택 콤보박스

    @FXML
    private ComboBox<String> cb_select_Si;
    //시 선택 콤보박스

    @FXML
    private TableColumn<?, ?> tc_touristSpotAddress;
    //관광지 주소 열

    @FXML
    private TableColumn<?, ?> tc_touristSpotCategory;
    //관광지 분류 열

    @FXML
    private TableColumn<?, ?> tc_touristSpotName;
    //관광지 이름 열

    @FXML
    private TextField tf_touristSpotAddress_Do;
    //추가할 관광지 도

    @FXML
    private TextField tf_touristSpotAddress_Si;
    //추가할 관광지 시

    @FXML
    private TextField tf_touristSpotAddress_roadName;
    //추가할 관광지 도로명

    @FXML
    private TextField tf_touristSpotAddress_roadNumber;
    //추가할 관광지 도로 번호

    @FXML
    private TextField tf_touristSpotCategory;
    //추가할 관광지 분류

    @FXML
    private TextField tf_touristSpotName;
    //추가할 관광지 이름
    public void initialize() {
        bt_touristSpot_register.setOnAction(event -> addNewPlayLands());
    }
    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

    public void addNewPlayLands(){
        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        AdditionDAO additionDAO = new AdditionDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        String Do = tf_touristSpotAddress_Do.getText();
        String si = tf_touristSpotAddress_Si.getText();
        String stName = tf_touristSpotAddress_roadName.getText();
        String stNum = tf_touristSpotAddress_roadNumber.getText();
        String Name = tf_touristSpotName.getText();
        String Sort = tf_touristSpotCategory.getText();

        String address = (Do + " " + si +" " + stName + " " + stNum);
        playLandDTO playLandDTO = new playLandDTO();
        playLandDTO.setName(Name);
        playLandDTO.setAddress(address);
        playLandDTO.setSort(Sort);
        playlandDAO.addPlayLand(playLandDTO);

        additionDAO.requestDelete(Name);  //  만약 리퀘스트에 같은 이름이 있으면 삭제함


    }

}
