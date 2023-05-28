package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Manager_ModifyRestaurant {

    @FXML
    private Button bt_restaurant_modify;
    //맛집 수정 버튼
    
    @FXML
    private Button bt_restaurant_remove;
    //맛집 삭제 버튼

    @FXML
    private Button bt_search_restaurant;
    //변경할 맛집 검색 버튼

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
    //변경할 맛집 도

    @FXML
    private TextField tf_restaurantAddress_Si;
    //변경할 맛집 시

    @FXML
    private TextField tf_restaurantAddress_roadName;
    //변경할 맛집 도로명

    @FXML
    private TextField tf_restaurantAddress_roadNumber;
    //변경할 맛집 도로 번호

    @FXML
    private TextField tf_restaurantCategory;
    //변경할 맛집 분류

    @FXML
    private TextField tf_restaurantName;
    //변경할 맛집 이름

    @FXML
    private TextField tf_search_restaurant;
    //변경할 맛집 검색

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

    @FXML
    void search_restaurant(ActionEvent event) {

    }

}
