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
import persistence.dao.playlandDAO;
import persistence.dto.foodDTO;
import persistence.dto.playLandDTO;

import java.util.List;

public class Manager_ModifyTouristSpot {

    @FXML
    private Button bt_touristSpot_modify;
    //관광지 정보 수정 버튼

    @FXML
    private Button bt_touristSpot_remove;
    //관광지 삭제 버튼

    @FXML
    private Button bt_search_touristSpot;
    //변경할 관광지 검색 버튼

    @FXML
    private ComboBox<?> cb_select_Do;
    //도 선택 콤보박스

    @FXML
    private ComboBox<String> cb_select_Si;
    //시 선택 콤보박스

    @FXML
    private TableColumn<?, ?> tc_touristSpotAddress;
    //관광지 주소 열

    @FXML
    private TableColumn<?, ?> tc_touristSpotCategory;
    //관광지 분류 열

    @FXML
    private TableColumn<?, ?> tc_touristSpotName;
    //관광지 이름 열

    @FXML
    private TextField tf_search_touristSpot;
    //변경할 관광지 검색

    @FXML
    private TextField tf_touristSpotAddress_Do;
    //변경할 관광지 도

    @FXML
    private TextField tf_touristSpotAddress_Si;
    //변경할 관광지 시

    @FXML
    private TextField tf_touristSpotAddress_roadName;
    //변경할 관광지 도로명

    @FXML
    private TextField tf_touristSpotAddress_roadNumber;
    //변경할 관광지 도로 번호

    @FXML
    private TextField tf_touristSpotCategory;
    //변경할 관광지 분류

    @FXML
    private TextField tf_touristSpotName;
    //변경할 관광지 이름

    @FXML
    private TableView<playLandDTO> tc_information_spot;

    @FXML
    void select_Do(ActionEvent event) {
        Information_Food.handleDo(event, cb_select_Si);
    }

    @FXML
    void select_Si(ActionEvent event) {

    }

    @FXML
    void search_touristSpot(ActionEvent event) {
        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        playLandDTO playLandDTOS = new playLandDTO();
        playLandDTOS.setName(tf_search_touristSpot.getText());
        playLandDTOS.setState((String) cb_select_Do.getValue());
        playLandDTOS.setCity(cb_select_Si.getValue());

        List<playLandDTO> playLands = playlandDAO.showPlayLand(playLandDTOS);
        ObservableList<playLandDTO> observablePlayLands = FXCollections.observableArrayList(playLands);

        tc_touristSpotAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_touristSpotName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_touristSpotCategory.setCellValueFactory(new PropertyValueFactory<>("sort"));

        tc_information_spot.setItems(observablePlayLands);
    }
    @FXML
    public void initialize() {

    }
    public void handleFoodTableMouseClicked3(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

            //선택한 행의 데이터 가져오기
            playLandDTO rowData = tc_information_spot.getSelectionModel().getSelectedItem();
            String address = rowData.getAddress();

            // 주소를 공백을 기준으로 분할하여 배열에 저장
            String[] addressParts = address.split(" ");

            // 도, 시, 도로명, 도로번호를 각각 할당
            String state = addressParts[0];
            String city = addressParts[1];
            String road = addressParts[2];
            String roadNumber = addressParts[3];

            String name = rowData.getName();
            String sort = rowData.getSort();


            playLandDTO transferData = new playLandDTO();
            transferData.setSort(sort);
            transferData.setAddress(address);
            transferData.setName(name);
            int result = playlandDAO.컬럼정보로_spot_id찾기(transferData);

            List<playLandDTO> spotList = playlandDAO.spotID_로_정보_찾기(result);
            if (!spotList.isEmpty()) {
                playLandDTO selectedSpot = spotList.get(0);

                // 검색된 맛집 정보를 해당 필드에 설정
                tf_touristSpotAddress_Do.setText(state);
                tf_touristSpotAddress_Si.setText(city);
                tf_touristSpotAddress_roadName.setText(road);
                tf_touristSpotAddress_roadNumber.setText(roadNumber);
                tf_touristSpotCategory.setText(selectedSpot.getSort());
                tf_touristSpotName.setText(selectedSpot.getName());
            }

        }}
    @FXML
  public void handleModifyTouristSpot(ActionEvent actionEvent){
        playLandDTO rowData = tc_information_spot.getSelectionModel().getSelectedItem();

        // 가져온 데이터에서 수정할 필드 값 추출
        String state = tf_touristSpotAddress_Do.getText();
        String city = tf_touristSpotAddress_Si.getText();
        String road = tf_touristSpotAddress_roadName.getText();
        String roadNumber = tf_touristSpotAddress_roadNumber.getText();
        String sort = tf_touristSpotCategory.getText();
        String name = tf_touristSpotName.getText();
        String address = state + " " + city + " " + road + " " + roadNumber;

        // 기존 spot_id 가져오기
        int spotId = rowData.getId();

        // 수정할 playLandDTO 생성
        playLandDTO playLandDTO = new playLandDTO();
        playLandDTO.setId(spotId);
        playLandDTO.setAddress(address);
        playLandDTO.setName(name);
        playLandDTO.setSort(sort);

        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        playlandDAO.updatePlayLand(playLandDTO);
  }

}
