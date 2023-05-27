package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Manager_AddRestaurant {

    @FXML
    private Button bt_restaurant_register;
    //맛집 추가 버튼

    @FXML
    private ComboBox<?> cb_select_Do;
    //도 선택 콤보박스

    @FXML
    private ComboBox<String> cb_select_Si;
    //시 선택 콤보박스

    @FXML
    private TableColumn<?, ?> tc_restaurantAddress;
    //맛집 주소 열

    @FXML
    private TableColumn<?, ?> tc_restaurantCategory;
    //맛집 분류 열

    @FXML
    private TableColumn<?, ?> tc_restaurantName;
    //맛집 이름 열

    @FXML
    private TextField tf_restaurantAddress_Do;
    //추가할 맛집 도

    @FXML
    private TextField tf_restaurantAddress_Si;
    //추가할 맛집 시

    @FXML
    private TextField tf_restaurantAddress_roadName;
    //추가할 맛집 도로명

    @FXML
    private TextField tf_restaurantAddress_roadNumber;
    //추가할 맛집 도로 번호

    @FXML
    private TextField tf_restaurantCategory;
    //추가할 맛집 분류

    @FXML
    private TextField tf_restaurantName;
    //추가할 맛집 상호명

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

}
