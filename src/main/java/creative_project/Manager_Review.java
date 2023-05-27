package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Manager_Review {

    @FXML
    private Button bt_remove_review;
    //리뷰 삭제 버튼

    @FXML
    private ComboBox<?> cb_select_Do;
    //도 선택 콤보박스

    @FXML
    private ComboBox<String> cb_select_Si;
    //시 선택 콤보박스

    @FXML
    private Tab tb_touristSpot_review;
    //관광지 리뷰 탭

    @FXML
    private TableColumn<?, ?> tc_restaurant_review;
    //맛집 리뷰 열

    @FXML
    private TableColumn<?, ?> tc_restaurant_score;
    //맛집 평점 열

    @FXML
    private TableColumn<?, ?> tc_restaurant_userName;
    //맛집 리뷰 유저 이름 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_review;
    //관광지 리뷰 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_score;
    //관광지 평점 열

    @FXML
    private TableColumn<?, ?> tc_touristSpot_userName;
    //관광지 리뷰 유저 이름 열

    @FXML
    private TableView<?> tv_restaurant_review;
    //맛집 리뷰 테이블 뷰

    @FXML
    private Tab tb_restaurant_review;
    //맛집 리뷰 탭

    @FXML
    private TableView<?> tv_touristSpot_review;
    //관광지 리뷰 테이블 뷰

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

}
