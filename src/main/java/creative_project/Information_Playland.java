package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import persistence.MyBatisConnectionFactory;
import persistence.dao.playlandDAO;
import persistence.dao.reviewDAO;
import persistence.dto.foodDTO;
import persistence.dto.playLandDTO;
import persistence.dto.reviewDTO;

import java.util.List;

public class Information_Playland {
    @FXML
    private Button btn_search_playland;

    @FXML
    private TableColumn<?, ?> tc_playland_address;

    @FXML
    private TableColumn<?, ?> tc_playland_name;

    @FXML
    private TableColumn<?, ?> tc_playland_score;

    @FXML
    private TableColumn<?, ?> tc_playland_review_nickname;

    @FXML
    private TableColumn<?, ?> tc_playland_review_rate;

    @FXML
    private TableColumn<?, ?> tc_playland_review;

    @FXML
    private ComboBox cb_information_Do;

    @FXML
    private ComboBox cb_information_Si;

    @FXML
    private TextField tf_search_playland;

    @FXML
    private TableView<playLandDTO> tv_information_playland;

    @FXML
    private TableView<reviewDTO> tv_selected_review;


    //테이블 뷰에 디비에서 가져온 관광지 정보 출력
    @FXML
    void view_search_playland(ActionEvent event) {
        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        playLandDTO pldto = new playLandDTO();
        pldto.setName(tf_search_playland.getText());
        pldto.setState((String)cb_information_Do.getValue());
        pldto.setCity((String)cb_information_Si.getValue());

        List<playLandDTO> playlands = playlandDAO.showPlayLand(pldto);
        ObservableList<playLandDTO> observablePlaylands = FXCollections.observableArrayList(playlands);

        tc_playland_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_playland_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_playland_score.setCellValueFactory(new PropertyValueFactory<>("score"));

        tv_information_playland.setItems(observablePlaylands);
    }

    //출력된 테이블 뷰에서 튜플 더블 클릭시 해당 행의 리뷰 정보 출력
    @FXML
    void handlePlaylandTableMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            reviewDAO rvDAO = new reviewDAO(MyBatisConnectionFactory.getSqlSessionFactory());
//
            //선택한 행의 데이터 가져오기
            playLandDTO rowData = tv_information_playland.getSelectionModel().getSelectedItem();

            List<reviewDTO> reviews = rvDAO.getPlaylandReview(rowData.getId());
            ObservableList<reviewDTO> observableReview = FXCollections.observableArrayList(reviews);

            tc_playland_review_nickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
            tc_playland_review_rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
            tc_playland_review.setCellValueFactory(new PropertyValueFactory<>("content"));

            tv_selected_review.setItems(observableReview);

        }
    }

}