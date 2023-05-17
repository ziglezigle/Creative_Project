package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableColumn<?, ?> tc_food_best;

    @FXML
    private TableColumn<?, ?> tc_food_name;

    @FXML
    private TableColumn<?, ?> tc_food_review;

    @FXML
    private TableColumn<?, ?> tc_food_score;

    @FXML
    private TextField tf_search_food;

    @FXML
    private TableView<?> tv_information_food;

    @FXML
    void view_search_food(ActionEvent event) {

    }

}
