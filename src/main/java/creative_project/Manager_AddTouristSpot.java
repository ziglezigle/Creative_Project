package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

}
