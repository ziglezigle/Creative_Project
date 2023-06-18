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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import persistence.MyBatisConnectionFactory;
import persistence.dao.RequestDAO;
import persistence.dao.foodDAO;
import persistence.dao.playlandDAO;
import persistence.dto.RequestDTO;
import persistence.dto.foodDTO;

import java.io.IOException;
import java.util.List;

public class Manager_ModifyRequireList {

    private int selectedFoodId = -1;
    private int selectedSpotId = -1;
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
    private TableColumn<?, ?> tc_touristSpot_spot_id;
    @FXML
    private TableColumn<?, ?> tc_touristSpot_request_id;
    @FXML
    private TableColumn<?, ?> tc_restaurant_food_id;
    @FXML
    private TableColumn<?, ?> tc_restaurant_request_id;

    @FXML
    private TableColumn<?, ?> tc_restaurant_sort;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_sort;


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
    private TableView<RequestDTO> tv_modify_touristSpot_requireList;
    //관광지 정보 수정 요청 테이블 뷰

    @FXML
    private TableView<RequestDTO> tv_restaurant_requireList;
    //맛집 정보 수정 요청 테이블 뷰

    @FXML
   public void initialize(){
        tp_requireList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == tp_modify_restaurantList) {
                viewSearchModifyFood();
            } else if (newValue == tp_modify_touristSpotList) {
                viewSearchModifySpot();

            }
        });

        Tab selectTab = tp_requireList.getSelectionModel().getSelectedItem();
        if(selectTab == tp_modify_restaurantList) {
            viewSearchModifyFood();
        }
        else if(selectTab == tp_modify_touristSpotList) {
            viewSearchModifySpot();
        }
    }

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
    RequestDAO requestDAO = new RequestDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    @FXML
    void remove_require(ActionEvent event) {
        Tab selectTab = tp_requireList.getSelectionModel().getSelectedItem();
        if(selectTab == tp_modify_restaurantList) {
            requestDAO.DeleteFood(selectedFoodId);
            foodDAO.deleteFood(selectedFoodId);
            selectedFoodId = -1;
        }
        else if(selectTab == tp_modify_touristSpotList) {
            requestDAO.DeleteSpot(selectedSpotId);
            playlandDAO.deleteSpot(selectedSpotId);
            selectedSpotId = -1;
        }
    }

    public void handleFoodTableMouseClickedFood(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            //선택한 행의 데이터 가져오기
            RequestDTO rowData = tv_restaurant_requireList.getSelectionModel().getSelectedItem();
             selectedFoodId = rowData.getFood_id();
            System.out.println("selectedFoodId = " + selectedFoodId);
        }
    }

    public void handleFoodTableMouseClickedSpot(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            //선택한 행의 데이터 가져오기
            RequestDTO rowData = tv_modify_touristSpot_requireList.getSelectionModel().getSelectedItem();
            selectedSpotId = rowData.getSpot_id();
            System.out.println("selectedSpotId = " + selectedSpotId);
        }
    }

    @FXML
    public void viewSearchModifyFood(){
        RequestDAO requestDAO = new RequestDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        List<RequestDTO> requestDTOS = requestDAO.getRequireFood();


        ObservableList<RequestDTO> requestDTOObservableFoodList = FXCollections.observableArrayList(requestDTOS);
         
        tc_restaurantName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_restaurantAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_restaurant_why_require.setCellValueFactory(new PropertyValueFactory<>("content"));
        tc_restaurant_request_id.setCellValueFactory(new PropertyValueFactory<>("chRequest_id"));
        tc_restaurant_food_id.setCellValueFactory(new PropertyValueFactory<>("food_id"));
        tc_restaurant_sort.setCellValueFactory(new PropertyValueFactory<>("sort"));

        tv_restaurant_requireList.setItems(requestDTOObservableFoodList);
    }

    @FXML
    public void viewSearchModifySpot(){
        RequestDAO requestDAO = new RequestDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<RequestDTO> requestDTOS = requestDAO.getRequireSpot();


        ObservableList<RequestDTO> requestDTOObservableSpotList = FXCollections.observableArrayList(requestDTOS);

        tc_touristSpotName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_touristSpotAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_touristSpot_why_require.setCellValueFactory(new PropertyValueFactory<>("content"));
        tc_touristSpot_request_id.setCellValueFactory(new PropertyValueFactory<>("chRequest_id"));
        tc_touristSpot_spot_id.setCellValueFactory(new PropertyValueFactory<>("spot_id"));
        tc_touristSpot_sort.setCellValueFactory(new PropertyValueFactory<>("sort"));

        tv_modify_touristSpot_requireList.setItems(requestDTOObservableSpotList);
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
