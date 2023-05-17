package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Memo {

    @FXML
    private Button btn_memo_add;

    @FXML
    private Button btn_menu_remove;

    @FXML
    private DatePicker dp_back;

    @FXML
    private DatePicker dp_go;

    @FXML
    private TextArea ta_memo_memo;

    @FXML
    private TableColumn<?, ?> tc_back;

    @FXML
    private TableColumn<?, ?> tc_go;

    @FXML
    private TableColumn<?, ?> tc_memo_food;

    @FXML
    private TableColumn<?, ?> tc_memo_memo;

    @FXML
    private TableColumn<?, ?> tc_memo_playland;

    @FXML
    private TextField tf_memo_food;

    @FXML
    private TextField tf_memo_playland;

    @FXML
    private TableView<?> tv_memo;

    @FXML
    void add_memo(ActionEvent event) {

    }

    @FXML
    void remove_memo(ActionEvent event) {

    }

}
