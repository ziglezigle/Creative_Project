package creative_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Manager_AddRestaurant {

    @FXML
    private Button bt_restaurant_register;

    @FXML
    private TableColumn<?, ?> tc_restaurantAddress;

    @FXML
    private TableColumn<?, ?> tc_restaurantCategory;

    @FXML
    private TableColumn<?, ?> tc_restaurantName;

    @FXML
    private TextField tf_restaurantAddress;

    @FXML
    private TextField tf_restaurantCategory;

    @FXML
    private TextField tf_restaurantName;

    @FXML
    private TableView<?> tv_restaurantList;
}
