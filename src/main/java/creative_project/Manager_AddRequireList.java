package creative_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Manager_AddRequireList {

    @FXML
    private Button bt_require_allow;

    @FXML
    private Tab tb_restaurant_require;

    @FXML
    private Tab tb_touristSpot_require;

    @FXML
    private TableColumn<?, ?> tc_restaurant_address;

    @FXML
    private TableColumn<?, ?> tc_restaurant_name;

    @FXML
    private TableColumn<?, ?> tc_restaurant_why;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_address;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_name;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_why;

    @FXML
    private TableView<?> tv_restaurant_require;

    @FXML
    private TableView<?> tv_touristSpot_require;

}
