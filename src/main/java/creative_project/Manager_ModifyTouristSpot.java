package creative_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Manager_ModifyTouristSpot {

    @FXML
    private Button bt_touristSpot_register;

    @FXML
    private TableColumn<?, ?> tc_touristSpotAddress;

    @FXML
    private TableColumn<?, ?> tc_touristSpotCategory;

    @FXML
    private TableColumn<?, ?> tc_touristSpotName;

    @FXML
    private TextField tf_touristSpotAddress;

    @FXML
    private TextField tf_touristSpotCategory;

    @FXML
    private TextField tf_touristSpotName;

    @FXML
    private TableView<?> tv_touristSpotList;

}
