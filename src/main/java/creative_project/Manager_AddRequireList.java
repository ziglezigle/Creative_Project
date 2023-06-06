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
import persistence.MyBatisConnectionFactory;
import persistence.dao.AdditionDAO;
import persistence.dto.AdditionDTO;

import java.io.IOException;
import java.util.List;

public class Manager_AddRequireList {
    AdditionDAO additionDAO = new AdditionDAO(MyBatisConnectionFactory.getSqlSessionFactory());

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
    private TableView<AdditionDTO> tv_restaurant_require;
    //맛집 추가 요청 테이블 뷰

    @FXML
    private TableView<AdditionDTO> tv_touristSpot_require;
    //관광지 추가 요청 테이블 뷰
    AdditionDTO additionDTO = new AdditionDTO();
      @FXML
    public void initialize(){
          tp_add_requireList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
              if (newValue == tb_restaurant_require) {
                  additionDTO.setSort("맛집");
                  viewSearchRequireFood(additionDTO);
              } else if (newValue == tb_touristSpot_require) {
                  additionDTO.setSort("관광지");
                  viewSearchRequireSpot(additionDTO);
              }
          });
          Tab selectedTab = tp_add_requireList.getSelectionModel().getSelectedItem();
          handleTabSelection(selectedTab);
    }
    private void handleTabSelection(Tab selectedTab) {
        if (selectedTab == tb_restaurant_require) {
            additionDTO.setSort("맛집");
            viewSearchRequireFood(additionDTO);
        } else if (selectedTab == tb_touristSpot_require) {
            additionDTO.setSort("관광지");
            viewSearchRequireSpot(additionDTO);
        }
    }
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
    @FXML
   public void viewSearchRequireFood(AdditionDTO adDTO){


        List<AdditionDTO> additionDTOS = additionDAO.viewRequirement(adDTO);
        ObservableList<AdditionDTO> additionDTOObservableList = FXCollections.observableArrayList(additionDTOS);

        tc_restaurant_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_restaurant_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_restaurant_why.setCellValueFactory(new PropertyValueFactory<>("content"));

        tv_restaurant_require.setItems(additionDTOObservableList);
    }
    @FXML
    public void viewSearchRequireSpot(AdditionDTO adDTO){
        List<AdditionDTO> additionDTOs = additionDAO.viewRequirement(adDTO);
        ObservableList<AdditionDTO> additionDTOObservableList = FXCollections.observableArrayList(additionDTOs);

        tc_touristSpot_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_touristSpot_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_touristSpot_why.setCellValueFactory(new PropertyValueFactory<>("content"));

        tv_touristSpot_require.setItems(additionDTOObservableList);
    }

}
