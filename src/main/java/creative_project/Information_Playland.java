package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.playlandDAO;
import persistence.dto.playLandDTO;

import java.util.List;

public class Information_Playland {

    @FXML
    private Button btn_search_playland;

    @FXML
    private ComboBox<?> cb_information_Do;

    @FXML
    private ComboBox<String> cb_information_Si;

    @FXML
    private TableColumn<?, ?> tc_playland_address;

    @FXML
    private TableColumn<?, ?> tc_playland_name;

    @FXML
    private TableColumn<?, ?> tc_playland_review;

    @FXML
    private TableColumn<?, ?> tc_playland_score;

    @FXML
    private TableColumn<?, ?> tc_playland_sort;

    @FXML
    private TextField tf_search_playland;

    @FXML
    private TableView<playLandDTO> tv_information_playland;

    @FXML
    void view_search_playland(ActionEvent event) {
        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<playLandDTO> playlands = playlandDAO.showPlayLand();
        ObservableList<playLandDTO> observablePlaylands = FXCollections.observableArrayList(playlands);

        tc_playland_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_playland_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_playland_review.setCellValueFactory(new PropertyValueFactory<>("review"));
        tc_playland_score.setCellValueFactory(new PropertyValueFactory<>("score"));
        tc_playland_sort.setCellValueFactory(new PropertyValueFactory<>("sort"));

        tv_information_playland.setItems(observablePlaylands);
    }

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_information_Si);
    }

}
