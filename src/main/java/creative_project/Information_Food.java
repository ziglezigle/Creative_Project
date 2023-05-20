package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.foodDAO;
import persistence.dto.foodDTO;


import java.util.List;

public class Information_Food {

    @FXML
    private Button btn_search_food;

    @FXML
    private MenuButton mb_information_Do;

    @FXML
    private MenuButton mb_information_Si;

    @FXML
    private TableColumn<?, ?> tc_food_address;

    @FXML
    private TableColumn<?, ?> tc_food_category;

    @FXML
    private TableColumn<?, ?> tc_food_name;

    @FXML
    private TableColumn<?, ?> tc_food_review;

    @FXML
    private TableColumn<?, ?> tc_food_score;

    @FXML
    private TextField tf_search_food;

    @FXML
    private TableView<foodDTO> tv_information_food;

    @FXML
    void view_search_food(ActionEvent event) {
        foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<foodDTO> foods = foodDAO.showFood();
        ObservableList<foodDTO> observableFoods = FXCollections.observableArrayList(foods);

        tc_food_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_food_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_food_review.setCellValueFactory(new PropertyValueFactory<>("review"));
        tc_food_score.setCellValueFactory(new PropertyValueFactory<>("score"));
        tc_food_category.setCellValueFactory(new PropertyValueFactory<>("category"));

        tv_information_food.setItems(observableFoods);
    }

}
