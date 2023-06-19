package creative_project;

import java.util.HashMap;
import java.util.List;

import javafx.collections.ObservableList;
import persistence.MyBatisConnectionFactory;
import persistence.dao.memoDAO;
import persistence.dto.memoDTO;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.Window;

public class Memo {


    // 메모 추가,수정,삭제하는 창 넘어가는 버튼
    @FXML
    private Button btnManage;

    // 6월 달력 넘어가는 버튼
    @FXML
    private Button btn_nextMonth;

    // 몇월 달력인지 나타내는 버튼
    @FXML
    private Button btn_month;

    // 달력 보여주는 공간
    @FXML
    private GridPane grid;

    // 달력 보여주는 공간 담은 pane
    @FXML
    private Pane pane;

    @FXML
    private Pane Pane;

    // 5월 1일에 메모 적은 거 띄워주는 텍스트 필드...31일까지 쭉 있음 tf 여기에다가 메모 내용 띄울 수 있다고 함
    @FXML
    private TextField tf_memo_01;

    // 5월 2일에 메모 적은 거 띄워주는 텍스트 필드
    @FXML
    private TextField tf_memo_02;

    // 밑으로 쭉쭉 간데이
    @FXML
    private TextField tf_memo_03;

    @FXML
    private TextField tf_memo_04;

    @FXML
    private TextField tf_memo_05;

    @FXML
    private TextField tf_memo_06;

    @FXML
    private TextField tf_memo_07;

    @FXML
    private TextField tf_memo_08;

    @FXML
    private TextField tf_memo_09;

    @FXML
    private TextField tf_memo_10;

    @FXML
    private TextField tf_memo_11;

    @FXML
    private TextField tf_memo_12;

    @FXML
    private TextField tf_memo_13;

    @FXML
    private TextField tf_memo_14;

    @FXML
    private TextField tf_memo_15;

    @FXML
    private TextField tf_memo_16;

    @FXML
    private TextField tf_memo_17;

    @FXML
    private TextField tf_memo_18;

    @FXML
    private TextField tf_memo_19;

    @FXML
    private TextField tf_memo_20;

    @FXML
    private TextField tf_memo_21;

    @FXML
    private TextField tf_memo_22;

    @FXML
    private TextField tf_memo_23;

    @FXML
    private TextField tf_memo_24;

    @FXML
    private TextField tf_memo_25;

    @FXML
    private TextField tf_memo_26;

    @FXML
    private TextField tf_memo_27;

    @FXML
    private TextField tf_memo_28;

    @FXML
    private TextField tf_memo_29;

    @FXML
    private TextField tf_memo_30;


    @FXML
    public void initialize() {
        // Call the method to load memos and display them in the TextFields
        displayMemoContents();
    }

    private void displayMemoContents() {
        memoDAO dao = new memoDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        // Convert ArrayList to ObservableList using FXCollections
        List<memoDTO> memoListTemp = dao.showMemo();
        ObservableList<memoDTO> memoList = FXCollections.observableArrayList(memoListTemp);


        // Create a mapping between TextField fx:id and date IDs
        HashMap<String, TextField> textFieldMapping = new HashMap<>();
        textFieldMapping.put("01", tf_memo_01);
        textFieldMapping.put("02", tf_memo_02);
        textFieldMapping.put("03", tf_memo_03);
        textFieldMapping.put("04", tf_memo_04);
        textFieldMapping.put("05", tf_memo_05);
        textFieldMapping.put("06", tf_memo_06);
        textFieldMapping.put("07", tf_memo_07);
        textFieldMapping.put("08", tf_memo_08);
        textFieldMapping.put("09", tf_memo_09);
        textFieldMapping.put("10", tf_memo_10);
        textFieldMapping.put("11", tf_memo_11);
        textFieldMapping.put("12", tf_memo_12);
        textFieldMapping.put("13", tf_memo_13);
        textFieldMapping.put("14", tf_memo_14);
        textFieldMapping.put("15", tf_memo_15);
        textFieldMapping.put("16", tf_memo_16);
        textFieldMapping.put("17", tf_memo_17);
        textFieldMapping.put("18", tf_memo_18);
        textFieldMapping.put("19", tf_memo_19);
        textFieldMapping.put("20", tf_memo_20);
        textFieldMapping.put("21", tf_memo_21);
        textFieldMapping.put("22", tf_memo_22);
        textFieldMapping.put("23", tf_memo_23);
        textFieldMapping.put("24", tf_memo_24);
        textFieldMapping.put("25", tf_memo_25);
        textFieldMapping.put("26", tf_memo_26);
        textFieldMapping.put("27", tf_memo_27);
        textFieldMapping.put("28", tf_memo_28);
        textFieldMapping.put("29", tf_memo_29);
        textFieldMapping.put("30", tf_memo_30);

        for (TextField textField : textFieldMapping.values()) {
            textField.setText("");
        }

        for (memoDTO memo : memoList) {
            // Extract the date and memo from the memoDTO
            String dateString = memo.getDate();
            String[] dateArray = dateString.split("-");

            // Get day value and remove leading zeros
            String dayString = dateArray[2];

            // Check if the TextField mapping contains the corresponding date
            if (textFieldMapping.containsKey(dayString)) {
                TextField targetTextField = textFieldMapping.get(dayString);
                targetTextField.setText(memo.getInformation());
            }
        }
    }

    // 메모 수정,등록,삭제하는 창 넘어가는 버튼 메소드
    @FXML
    void manageMemo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Memo_Manage.fxml"));
            Parent root = loader.load();


            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("메모 관리");
            stage.setScene(new Scene(root));

            // 메모 관리 창이 닫힐 때 콜백 설정
            stage.setOnHidden(e -> {
                // 메모 내용 새로고침
                displayMemoContents();
            });

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
