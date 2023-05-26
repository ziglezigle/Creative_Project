package creative_project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.foodDAO;
import persistence.dao.playlandDAO;
import persistence.dao.reviewDAO;
import persistence.dto.*;

import java.io.IOException;
import java.util.List;

public class Add_Review {
    private String name = null, state = null, city = null, content = null;
    private double rate;

    private boolean foodTab = false, playlandTab = false;
    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_state;

    @FXML
    private TextField tf_city;


    @FXML
    private TextArea ta_review;

    @FXML
    private TextField tf_rate;

    @FXML
    private Tab tab_food;

    @FXML
    private Tab tab_playland;

    @FXML
    private TableColumn<?, ?> tc_food_name;

    @FXML
    private TableColumn<?, ?> tc_food_address;


    @FXML
    private TableColumn<?, ?> tc_playland_name;

    @FXML
    private TableColumn<?, ?> tc_plaland_address;


    @FXML
    private TableView<foodDTO> tv_resultView_food;

    @FXML
    private TableView<playLandDTO> tv_resultView_playland;


    //맛집, 관광지 검색 이벤트
    @FXML
    void view_result_search(ActionEvent event) {

        name = tf_name.getText();
        state = tf_state.getText();
        city = tf_city.getText();

        view_search_playland(new playLandDTO(name, state,city));
        view_search_Food(new foodDTO(name, state, city));
    }


    //리뷰 등록 이벤트
    @FXML
    void add_review(ActionEvent event) {

        foodTab = tab_food.isSelected();
        playlandTab = tab_playland.isSelected();

        //현재 사용중인 유저의 아이디 가져오기
        int user_id = userDTO.getUser_id();

        //reviewDTO에 바인딩할 변수값 설정
        int id = handleSelection();
        rate = Double.parseDouble(tf_rate.getText());
        content = ta_review.getText();

        //reviewDTO에 데이터 셋
        reviewDTO rdto = new reviewDTO(user_id, id, rate, content);
        reviewDAO rdao = new reviewDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        if(rate >= 0 && rate <= 5){
            try{
                if(foodTab) //음식점 탭이면 맛집 테이블에 insert
                    rdao.insertFoodReview(rdto);
                else if(playlandTab) //관광지 탭이면 관광지 테이블에 insert
                    rdao.insertPlaylandReview(rdto);

                mainGUI.alert("등록 성공", "정상적으로 등록되었습니다");
                resetPage(); //리뷰화면 초기화
            }catch(Exception e){
                mainGUI.alert("리뷰등록 실패", "잘못된 등록 정보입니다");
            }
        }else
            mainGUI.alert("리뷰등록 실패", "평점은 0~5사이여야 합니다");
    }


    //관광지 검색 메서드
    void view_search_playland(playLandDTO pldto){
        playlandDAO playLandDao = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<playLandDTO> playlands = playLandDao.showPlayLand_review(pldto);
        ObservableList<playLandDTO> observablePlayland = FXCollections.observableArrayList(playlands);

        tc_playland_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_plaland_address.setCellValueFactory(new PropertyValueFactory<>("address"));

        tv_resultView_playland.setItems(observablePlayland);
    }

    //맛집 검색 메서드
    void view_search_Food(foodDTO fdto){
        foodDAO foodDao = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        List<foodDTO> foods = foodDao.showFood_review(fdto);
        ObservableList<foodDTO> observableFood = FXCollections.observableArrayList(foods);

        tc_food_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_food_address.setCellValueFactory(new PropertyValueFactory<>("address"));

        tv_resultView_food.setItems(observableFood);
    }


    // 선택한 행 id값 추출
    private int handleSelection() {
        int id = 0;
        foodDTO selectedObjectFood;
        playLandDTO selectedObjectPlayland;
        if(foodTab) {
            selectedObjectFood = tv_resultView_food.getSelectionModel().getSelectedItem();
            id = selectedObjectFood.getId();
        } else if(playlandTab){
            selectedObjectPlayland = tv_resultView_playland.getSelectionModel().getSelectedItem();
            id = selectedObjectPlayland.getId();
        }
        return id;
    }

    private void resetPage(){
        tf_name.setText("");
        tf_state.setText("");
        tf_city.setText("");
        tf_rate.setText("");
        ta_review.setText("");

        // 테이블 뷰 초기화
        tv_resultView_playland.getItems().clear();
        tv_resultView_food.getItems().clear();
    }



}
