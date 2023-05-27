package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class Add_Review {

    @FXML
    private Button btn_add_use_list;

    @FXML
    private ComboBox<?> cb_score;

    @FXML
    private TextArea ta_use_review;

    @FXML
    private Tab tab_food;

    @FXML
    private Tab tab_playland;

    @FXML
    private TableColumn<?, ?> tc_use_fooddate;

    @FXML
    private TableColumn<?, ?> tc_use_foodname;

    @FXML
    private TableColumn<?, ?> tc_use_plalanddate;

    @FXML
    private TableColumn<?, ?> tc_use_playlandname;

    @FXML
    private TabPane tp_use_list;

    @FXML
    private TableView<?> tv_use_food;

    @FXML
    private TableView<?> tv_use_playland;

    @FXML
    void add_use_list(ActionEvent event) {

    }

}
