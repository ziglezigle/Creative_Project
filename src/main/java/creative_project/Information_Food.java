package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import persistence.MyBatisConnectionFactory;
import persistence.dao.foodDAO;
import persistence.dao.reviewDAO;
import persistence.dto.foodDTO;
import persistence.dto.reviewDTO;

import java.util.List;

public class Information_Food {

    @FXML
    private Button btn_search_food;

    @FXML
    private ComboBox<String> cb_information_Do;

    @FXML
    private ComboBox<String> cb_information_Si;

    @FXML
    private TableColumn<?, ?> tc_food_address;

    @FXML
    private TableColumn<?, ?> tc_food_category;

    @FXML
    private TableColumn<?, ?> tc_food_name;

    @FXML
    private TableColumn<?, ?> tc_food_score;

    @FXML
    private TableColumn<?, ?> tc_food_review_nickname;

    @FXML
    private TableColumn<?, ?> tc_food_review_rate;

    @FXML
    private TableColumn<?, ?> tc_food_review;

    @FXML
    private ComboBox cb_food_Do;

    @FXML
    private ComboBox cb_food_Si;

    @FXML
    private TextField tf_search_food;

    @FXML
    private TableView<reviewDTO> tv_selected_review;
    @FXML
    private TableView<foodDTO> tv_information_food;

    //테이블 뷰에 디비에서 가져온 맛집 정보 출력
    @FXML
    void view_search_food(ActionEvent event) {
        foodDAO foodDAO = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        foodDTO fdto = new foodDTO();
        fdto.setName(tf_search_food.getText());
        fdto.setState((String)cb_food_Do.getValue());
        fdto.setCity((String)cb_food_Si.getValue());

        List<foodDTO> foods = foodDAO.showFood(fdto);
        ObservableList<foodDTO> observableFoods = FXCollections.observableArrayList(foods);

        tc_food_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_food_name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        tc_food_review.setCellValueFactory(new PropertyValueFactory<>("review"));
        tc_food_score.setCellValueFactory(new PropertyValueFactory<>("score"));
        tc_food_category.setCellValueFactory(new PropertyValueFactory<>("category"));

        tv_information_food.setItems(observableFoods);

    }

    //출력된 테이블 뷰에서 튜플 더블 클릭시 해당 행의 리뷰 정보 출력
    @FXML
    void handleFoodTableMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            reviewDAO rvDAO = new reviewDAO(MyBatisConnectionFactory.getSqlSessionFactory());

            //선택한 행의 데이터 가져오기
            foodDTO rowData = tv_information_food.getSelectionModel().getSelectedItem();

            List<reviewDTO> reviews = rvDAO.getFoodReview(rowData.getId());
            ObservableList<reviewDTO> observableReview = FXCollections.observableArrayList(reviews);

            tc_food_review_nickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
            tc_food_review_rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
            tc_food_review.setCellValueFactory(new PropertyValueFactory<>("content"));

            tv_selected_review.setItems(observableReview);

        }
    }
}
