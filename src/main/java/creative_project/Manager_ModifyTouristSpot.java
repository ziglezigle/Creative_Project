package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.playlandDAO;
import persistence.dto.playLandDTO;

import java.util.List;

public class Manager_ModifyTouristSpot {

    @FXML
    private Button bt_touristSpot_modify;
    //관광지 정보 수정 버튼

    @FXML
    private Button bt_touristSpot_remove;
    //관광지 삭제 버튼

    @FXML
    private Button bt_search_touristSpot;
    //변경할 관광지 검색 버

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
    private TextField tf_search_touristSpot;
    //변경할 관광지 검색

    @FXML
    private TextField tf_touristSpotAddress_Do;
    //변경할 관광지 도

    @FXML
    private TextField tf_touristSpotAddress_Si;
    //변경할 관광지 시

    @FXML
    private TextField tf_touristSpotAddress_roadName;
    //변경할 관광지 도로명

    @FXML
    private TextField tf_touristSpotAddress_roadNumber;
    //변경할 관광지 도로 번호

    @FXML
    private TextField tf_touristSpotCategory;
    //변경할 관광지 분류

    @FXML
    private TextField tf_touristSpotName;
    //변경할 관광지 이름

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

    @FXML
    void search_touristSpot(ActionEvent event) {

    }
    @FXML
    public void initialize() {

    }
    @FXML
    public void view_search_playLand(ActionEvent event) {

    }
}
