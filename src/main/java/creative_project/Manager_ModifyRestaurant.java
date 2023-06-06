package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import persistence.MyBatisConnectionFactory;
import persistence.dao.foodDAO;
import persistence.dao.playlandDAO;
import persistence.dao.reviewDAO;
import persistence.dto.foodDTO;
import persistence.dto.playLandDTO;
import persistence.dto.reviewDTO;

import java.util.List;

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
    private TableView<foodDTO> tc_information_food;

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

    @FXML
    void search_restaurant(ActionEvent event) {
        foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        foodDTO fdto = new foodDTO();
        fdto.setName(tf_search_restaurant.getText());
        fdto.setState((String) cb_select_Do.getValue());
        fdto.setCity(cb_select_Si.getValue());

        List<foodDTO> foods = foodDAO.showFood(fdto);
        ObservableList<foodDTO> observableFoods = FXCollections.observableArrayList(foods);

        tc_restaurantAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_restaurantName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_restaurantCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        tc_information_food.setItems(observableFoods);
    }

    public void handleFoodTableMouseClicked2(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());

            //선택한 행의 데이터 가져오기
            foodDTO rowData = tc_information_food.getSelectionModel().getSelectedItem();
            String address = rowData.getAddress();

            String[] addressParts = address.split(" ");  // 주소 문자열을 공백을 기준으로 분리
            String name = rowData.getName();
            String state = addressParts[0];  // 도 정보
            String city = addressParts[1];  // 시 정보
            String roadName = addressParts[2];  // 도로명 정보
            int roadNo = Integer.parseInt(addressParts[3]);  // 도로번호 정보


             String category = rowData.getCategory();


             foodDTO transferData = new foodDTO(name,state,city,roadName,roadNo,category);
             int result = foodDAO.컬럼정보로_id찾기(transferData);

            List<foodDTO> foodList = foodDAO.foodID_로_정보_찾기(result);
            if (!foodList.isEmpty()) {
                foodDTO selectedFood = foodList.get(0);

                // 검색된 맛집 정보를 해당 필드에 설정
                tf_restaurantAddress_Do.setText(selectedFood.getState());
                tf_restaurantAddress_Si.setText(selectedFood.getCity());
                tf_restaurantAddress_roadNumber.setText(String.valueOf(selectedFood.getRoad_no()));
                tf_restaurantAddress_roadName.setText(selectedFood.getRoad());
                tf_restaurantCategory.setText(selectedFood.getCategory());
                tf_restaurantName.setText(selectedFood.getName());
            }

        }

    }

    public void handleModifyFood(ActionEvent actionEvent) {
        foodDTO rowData = tc_information_food.getSelectionModel().getSelectedItem();

        // 가져온 데이터에서 수정할 필드 값 추출
        String state = tf_restaurantAddress_Do.getText();
        String city = tf_restaurantAddress_Si.getText();
        String road = tf_restaurantAddress_roadName.getText();
        String roadNumber = tf_restaurantAddress_roadNumber.getText();
        String category = tf_restaurantCategory.getText();
        String name = tf_restaurantName.getText();


        // 기존 id 가져오기
        int foodId = rowData.getId();

        // 수정할 foodDTO 생성
        foodDTO foodDTO = new foodDTO();
        foodDTO.setId(foodId);
        foodDTO.setRoad(road);
        foodDTO.setCity(city);
        foodDTO.setState(state);
        foodDTO.setRoad_no(Integer.parseInt(roadNumber));
        foodDTO.setName(name);
        foodDTO.setCategory(category);

        foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        foodDAO.updateFood(foodDTO);
    }
}

