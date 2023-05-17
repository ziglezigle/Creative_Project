package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Recommendation {

    @FXML
    private MenuButton mb_recommend_Do;

    @FXML
    private MenuButton mb_recommend_Si;

    @FXML
    private MenuButton mb_recommend_what;

    @FXML
    private MenuItem menu_review;

    @FXML
    private MenuItem menu_visitor;

    @FXML
    private TableColumn<?, ?> tc_recommend_food;

    @FXML
    private TableColumn<?, ?> tc_recommend_playland;

    @FXML
    private TableView<?> tv_recommend;

    @FXML
    void array_review(ActionEvent event) {

    }

    @FXML
    void array_visitor(ActionEvent event) {

    }

}
