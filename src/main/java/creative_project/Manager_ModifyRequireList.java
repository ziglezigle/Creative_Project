package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import persistence.dto.AdditionDTO;

import java.io.IOException;
import java.util.List;

public class Manager_ModifyRequireList {

    @FXML
    private Button bt_modify;
    //수정 버튼

    @FXML
    private Button bt_remove;
    //삭제 버튼

    @FXML
    private TableColumn<?, ?> tc_restaurantAddress;
    //맛집 주소 열

    @FXML
    private TableColumn<?, ?> tc_restaurantName;
    //맛집 이름 열

    @FXML
    private TableColumn<?, ?> tc_restaurant_why_require;
    //맛집 추천 사유 열

    @FXML
    private TableColumn<?, ?> tc_touristSpotAddress;
    //관광지 주소 열

    @FXML
    private TableColumn<?, ?> tc_touristSpotName;
    //관광지 이름 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_why_require;
    //관광지 추천 사유 열

    @FXML
    private Tab tp_modify_restaurantList;
    //맛집 리스트 탭

    @FXML
    private Tab tp_modify_touristSpotList;
    //관광지 리스트 탭

    @FXML
    private TabPane tp_requireList;
    //수정 요청 탭페인

    @FXML
    private TableView<?> tv_modify_touristSpot_requireList;
    //관광지 정보 수정 요청 테이블 뷰

    @FXML
    private TableView<?> tv_restaurant_requireList;
    //맛집 정보 수정 요청 테이블 뷰

    @FXML
    void modify_require(ActionEvent event) {
        Tab selectTab = tp_requireList.getSelectionModel().getSelectedItem();
        if(selectTab == tp_modify_restaurantList) {
            openFXMLWindow("Manager_ModifyRestaurant.fxml");
        }
        else if(selectTab == tp_modify_touristSpotList) {
            openFXMLWindow("Manager_ModifyTouristSpot.fxml");
        }
    }

    @FXML
    void remove_require(ActionEvent event) {

    }
//    @FXML
//    public void viewSearchRequireFood(AdditionDTO adDTO){
//
//
//        List<AdditionDTO> additionDTOS = additionDAO.viewRequirement(adDTO);
//        ObservableList<AdditionDTO> additionDTOObservableList = FXCollections.observableArrayList(additionDTOS);
//
//        tc_restaurant_name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        tc_restaurant_address.setCellValueFactory(new PropertyValueFactory<>("address"));
//        tc_restaurant_why.setCellValueFactory(new PropertyValueFactory<>("content"));
//
//        tv_restaurant_require.setItems(additionDTOObservableList);
//    }
//    @FXML
//    public void viewSearchRequireSpot(AdditionDTO adDTO){
//        List<AdditionDTO> additionDTOs = additionDAO.viewRequirement(adDTO);
//        ObservableList<AdditionDTO> additionDTOObservableList = FXCollections.observableArrayList(additionDTOs);
//
//        tc_touristSpot_name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        tc_touristSpot_address.setCellValueFactory(new PropertyValueFactory<>("address"));
//        tc_touristSpot_why.setCellValueFactory(new PropertyValueFactory<>("content"));
//
//        tv_touristSpot_require.setItems(additionDTOObservableList);
//    }
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
