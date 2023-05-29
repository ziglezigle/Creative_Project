package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import persistence.MyBatisConnectionFactory;
import persistence.dao.AdditionDAO;
import persistence.dao.foodDAO;
import persistence.dao.playlandDAO;
import persistence.dto.foodDTO;

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

    public void initialize() {
        bt_restaurant_register.setOnAction(event -> addNewFood());
    }
    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

    public void addNewFood(){
        foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        AdditionDAO additionDAO = new AdditionDAO(MyBatisConnectionFactory.getSqlSessionFactory());

       String Do = tf_restaurantAddress_Do.getText();
        String si = tf_restaurantAddress_Si.getText();
        String stName = tf_restaurantAddress_roadName.getText();
        int stNum = Integer.parseInt(tf_restaurantAddress_roadNumber.getText());
        String foodName = tf_restaurantName.getText();
        String foodSort = tf_restaurantCategory.getText();

        foodDTO food = new foodDTO();
        food.setName(foodName);
        food.setCategory(foodSort);
        food.setCity(si);
        food.setState(Do);
        food.setRoad(stName);
        food.setRoad_no(stNum);
        foodDAO.addFood(food);

        additionDAO.requestDelete(foodName);  //  만약 리퀘스트에 같은 이름이 있으면 삭제함

    }


}
