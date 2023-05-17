package creative_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Manager_ModifyRequireList {

    @FXML
    private Button bt_modify;

    @FXML
    private Button bt_remove;

    @FXML
    private TableColumn<?, ?> tc_restaurantAddress;

    @FXML
    private TableColumn<?, ?> tc_restaurantName;

    @FXML
    private TableColumn<?, ?> tc_restaurant_why_require;

    @FXML
    private TableColumn<?, ?> tc_touristSpotAddress;

    @FXML
    private TableColumn<?, ?> tc_touristSpotName;

    @FXML
    private TableColumn<?, ?> tc_touristSpot_why_require;

    @FXML
    private Tab tp_modify_restaurantList;

    @FXML
    private Tab tp_modify_touristSpotList;

    @FXML
    private TableView<?> tv_modify_touristSpot_requireList;

    @FXML
    private TableView<?> tv_restaurant_requireList;

}
