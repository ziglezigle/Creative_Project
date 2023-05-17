package creative_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Manager_Review {

    @FXML
    private Button bt_remove_review;

    @FXML
    private Tab tb_touristSpot_review;

    @FXML
    private TableColumn<?, ?> tc_restaurant_reivew;

    @FXML
    private TableColumn<?, ?> tc_restaurant_score;

    @FXML
    private TableColumn<?, ?> tc_restaurant_userName;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_reivew;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_score;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_userName;

    @FXML
    private TableView<?> tv_restaurant_reivew;

    @FXML
    private Tab tv_restaurant_review;

    @FXML
    private TableView<?> tv_touristSpot_reivew;

}
