package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.RequestDAO;
import persistence.dao.foodDAO;
import persistence.dao.playlandDAO;
import persistence.dto.RequestDTO;
import persistence.dto.foodDTO;
import persistence.dto.playLandDTO;

import java.util.List;

public class Require_Modify {

    private String name, state, city, content, sort;
    private int id = 0;
    private boolean foodTab = false, playlandTab = false;

    @FXML
    private Tab tab_playland;
    
    @FXML
    private TableView tv_resultView_playland;
    
    @FXML
    private TableColumn tc_playland_name;

    @FXML
    private TableColumn tc_plaland_address;

    @FXML
    private TableColumn tc_playLand_id;

    @FXML
    private Tab tab_food;

    @FXML
    private TableView tv_resultView_food;

    @FXML
    private TableColumn tc_food_name;

    @FXML
    private TableColumn tc_food_address;

    @FXML
    private TableColumn tc_food_id;

    @FXML
    private ComboBox cb_Do;

    @FXML
    private ComboBox cb_Si;

    @FXML
    private void setSiInfo(){}


    @FXML
    private CheckBox cb_modify;

    @FXML
    private CheckBox cb_delete;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_content;

    @FXML
    void view_result_search(ActionEvent event) {

        name = tf_name.getText();
        state = (String)cb_Do.getValue();
        city = (String)cb_Si.getValue();

        view_search_playland(new playLandDTO(name, state,city));
        view_search_Food(new foodDTO(name, state, city));
    }
    @FXML
    void add_request(ActionEvent event){
        RequestDAO dao = new RequestDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        RequestDTO dto = null;

        //현재 사용중인 유저의 아이디 가져오기
//        int user_id = UserInfo.getUser_id();
        int user_id = 1;

        if (cb_modify.isSelected()) {
            sort = "수정";
        } else if (cb_delete.isSelected()) {
            sort = "삭제";
        } else {
            mainGUI.alert("체크박스를 선택해주세요", "잘못된 등록 정보입니다");
            return;
        }
        System.out.println(sort);

        //RequestDTO에 데이터 셋
        dto = new RequestDTO(user_id, id, sort, tf_content.getText());

        if(foodTab) //음식점 탭이면 맛집 테이블에 insert
            dao.insertRequestFood(dto);
        else if(playlandTab) //관광지 탭이면 관광지 테이블에 insert
            dao.insertRequestPlayland(dto);
        mainGUI.alert("등록 성공", "정상적으로 등록되었습니다");

    }

    //관광지 검색 메서드
    void view_search_playland(playLandDTO pldto){
        playlandDAO playLandDao = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<playLandDTO> playlands = playLandDao.showPlayLand_review(pldto);
        ObservableList<playLandDTO> observablePlayland = FXCollections.observableArrayList(playlands);

        tc_playland_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_plaland_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_playLand_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_resultView_playland.setItems(observablePlayland);
    }

    //맛집 검색 메서드
    void view_search_Food(foodDTO fdto){
        foodDAO foodDao = new foodDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        List<foodDTO> foods = foodDao.showFood_review(fdto);
        ObservableList<foodDTO> observableFood = FXCollections.observableArrayList(foods);

        tc_food_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_food_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_food_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        tv_resultView_food.setItems(observableFood);
    }

    @FXML
    private void handleSelection() {
        foodDTO selectedObjectFood;
        playLandDTO selectedObjectPlayland;


        foodTab = tab_food.isSelected();
        playlandTab = tab_playland.isSelected();

        if(foodTab) {
            selectedObjectFood = (foodDTO) tv_resultView_food.getSelectionModel().getSelectedItem();
            id = selectedObjectFood.getId();
        } else if(playlandTab){
            selectedObjectPlayland = (playLandDTO) tv_resultView_playland.getSelectionModel().getSelectedItem();
            id = selectedObjectPlayland.getId();
        }
    }

    public void setSiInfo(ActionEvent actionEvent) {
        try {
            ROKArea.handleDo((String)cb_Do.getValue(), cb_Si);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
