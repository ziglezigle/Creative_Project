package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import persistence.MyBatisConnectionFactory;
import persistence.dao.memoDAO;
import persistence.dao.requireAddDAO;
import persistence.dto.memoDTO;
import persistence.dto.requireAddDTO;

public class Require_Add {

    // 맛집,관광지 추가 요청 버튼
    @FXML
    private Button btn_add_list;

    // 맛집, 관광지 중 뭘 추천하는지 고르는 콤보박스
    @FXML
    private ComboBox<String> cb_choose_list;

    //도 고르는 콤보박스
    @FXML
    private ComboBox<String> cb_information_Do;

    //시 고르는 콤보박스
    @FXML
    private ComboBox<String> cb_information_Si;

    // 맛집,관광지 등록 추천 이유 적는 곳
    @FXML
    private TextArea ta_require;

    // 맛집,관광지의 이름 적는 곳
    @FXML
    private TextField tf_nameOf_there;

    @FXML
    private TextField tf_address;

    // 맛집, 관광지 추가 요청 등록 버튼 메소드
    @FXML
    void addRequire(ActionEvent event) {

        String selectedList = cb_choose_list.getValue();
        String selectedDo = cb_information_Do.getValue();
        String selectedSi = cb_information_Si.getValue();

        String writtenName = tf_nameOf_there.getText();
        String thereSort = selectedList;
        String thereState = selectedDo;
        String thereCity = selectedSi;
        String requireContent = ta_require.getText();
        String thereAddress = tf_address.getText();

        requireAddDTO newRequireData = new requireAddDTO(writtenName, thereState, thereCity, thereSort, requireContent, thereAddress );
        requireAddDAO dao = new requireAddDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        dao.addRequire(newRequireData);

//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("추가 요청 성공");
//        alert.setHeaderText(null);
//        alert.setContentText("추가 요청이 성공적으로 등록되었습니다.");
//        alert.showAndWait();



    }


    @FXML
    void select_Do(ActionEvent event) {
        handleDo(event, cb_information_Si);
    }


    static void handleDo(ActionEvent event, ComboBox<String> secondComboBox) {
        ComboBox<String> DoComboBox = (ComboBox<String>) event.getSource();
        String selectOption = DoComboBox.getValue();

        if(selectOption.equals("서울특별시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중량구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구");
        }
        else if(selectOption.equals("부산광역시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군");
        }
        else if(selectOption.equals("대구광역시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군");
        }
        else if(selectOption.equals("인천광역시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "웅진군");
        }
        else if(selectOption.equals("광주광역시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("동구", "서구", "남구", "북구", "광산구");
        }
        else if(selectOption.equals("대전광역시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("동구", "중구", "서구", "유성구", "대덕구");
        }
        else if(selectOption.equals("울산광역시")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("중구", "남구", "동구", "북구", "울주군");
        }
        else if(selectOption.equals("세종특별자치시")) {
            secondComboBox.setDisable(true);
            secondComboBox.getItems().clear();
        }
        else if(selectOption.equals("제주특별자치도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("서귀포시", "제주시");
        }
        else if(selectOption.equals("경기도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("고양시", "수원시", "용인시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "시흥시", "안산시", "안성시", "안양시", "양주시", "여주시", "오산시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시", "가평군", "양평군", "연천군");
        }
        else if(selectOption.equals("경상북도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시", "영주시", "영천시", "포항시", "고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군");
        }
        else if(selectOption.equals("경상남도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("창원시", "거제시", "김해시", "밀양시", "사천시", "양산시", "진주시", "통영시", "거창군", "고창군", "남해군", "산청군", "의령군", "창녕군", "하동군", "함안군", "함양군", "합천군");
        }
        else if(selectOption.equals("전라북도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군");
        }
        else if(selectOption.equals("전라남도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군");
        }
        else if(selectOption.equals("충청북도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "증평군", "진천군");
        }
        else if(selectOption.equals("충청남도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("계룡시", "공주시", "논산시", "당진시", "보령시", "서산시", "아산시", "천안시", "금산군", "부여군", "서천군", "예산군", "청양군", "태안군", "홍성군");
        }
        else if(selectOption.equals("강원도")) {
            secondComboBox.setDisable(false);
            secondComboBox.getItems().setAll("강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군", "양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군");
        }
        else {
            secondComboBox.setDisable(true);
            secondComboBox.getItems().clear();
        }}}
