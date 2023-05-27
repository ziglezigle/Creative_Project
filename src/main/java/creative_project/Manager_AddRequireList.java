package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Manager_AddRequireList {

    @FXML
    private Button bt_require_allow;
    //추가 버튼

    @FXML
    private Tab tb_restaurant_require;
    //맛집 탭

    @FXML
    private Tab tb_touristSpot_require;
    //관광지 탭

    @FXML
    private TabPane tp_add_requireList;
    //탭페인

    @FXML
    private TableColumn<?, ?> tc_restaurant_address;
    //맛집 주소 열

    @FXML
    private TableColumn<?, ?> tc_restaurant_name;
    //맛집 이름 열

    @FXML
    private TableColumn<?, ?> tc_restaurant_why;
    //맛집 추천 이유 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_address;
    //관광지 주소 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_name;
    //관광지 이름 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_why;
    //관광지 추천 이유 열

    @FXML
    private TableView<?> tv_restaurant_require;
    //맛집 추가 요청 테이블 뷰

    @FXML
    private TableView<?> tv_touristSpot_require;
    //관광지 추가 요청 테이블 뷰

    @FXML
    void add_require(ActionEvent event) {
        Tab selectTab = tp_add_requireList.getSelectionModel().getSelectedItem();
        if(selectTab == tb_restaurant_require) {
            openFXMLWindow("Manager_AddRestaurant.fxml");
        }
        else if(selectTab == tb_touristSpot_require) {
            openFXMLWindow("Manager_AddTouristSpot.fxml");
        }
    }

    private void openFXMLWindow(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
