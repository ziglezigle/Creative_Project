    package creative_project;

    import javafx.collections.FXCollections;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import persistence.MyBatisConnectionFactory;
    import persistence.dao.memoDAO;
    import persistence.dto.memoDTO;

    import java.util.List;

    public class Memo_Manage {

        @FXML
        private DatePicker dp_memo;

        @FXML
        private Button mb_Add;

        @FXML
        private TextArea ta_Memo;

        @FXML
        private TableColumn<memoDTO, String> tc_date;

        @FXML
        private TableColumn<memoDTO, String> tc_memo;

        @FXML
        private TableView<memoDTO> tv_memo;

        @FXML
        private TextField tf_view_date;

        @FXML
        private TextArea ta_view_memo;

        @FXML
        public void initialize() {
            // 파일 실행 시 초기화되는 메서드입니다.
            refreshMemoList();

            // 테이블 뷰의 선택 이벤트 리스너를 설정합니다.
            tv_memo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    // 선택된 행의 데이터를 가져옵니다.
                    memoDTO selectedMemo = newSelection;

                    // tc_date와 tc_memo의 정보를 tf_view_date와 ta_view_memo에 설정합니다.
                    tf_view_date.setText(selectedMemo.getDate());
                    ta_view_memo.setText(selectedMemo.getInformation());
                }
            });
        }

        // 메모 목록을 불러와 TableView에 표시합니다.
        private void refreshMemoList() {
            memoDAO dao = new memoDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            List<memoDTO> memoList = dao.showMemo();

            // tc_date 컬럼에 날짜 데이터를 표시합니다.
            tc_date.setCellValueFactory(new PropertyValueFactory<>("date"));

            // tc_memo 컬럼에 메모 내용을 표시합니다.
            tc_memo.setCellValueFactory(new PropertyValueFactory<>("information"));

            // 테이블 뷰에 데이터를 설정합니다.
            tv_memo.setItems(FXCollections.observableArrayList(memoList));
        }

        @FXML
        void addMemo(ActionEvent event) {
            String selectedDate = dp_memo.getValue().toString();
            String memoContent = ta_Memo.getText();

            memoDTO newMemoData = new memoDTO(selectedDate, memoContent);
            memoDAO dao = new memoDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            dao.addMemo(newMemoData);

            dp_memo.setValue(null);
            ta_Memo.clear();

            // 새로운 메모 추가 후 목록을 갱신합니다.
            refreshMemoList();
        }

        @FXML
        void modifyMemo(ActionEvent event) {
            memoDTO selectedMemo = tv_memo.getSelectionModel().getSelectedItem();
            if (selectedMemo != null) {
                String newDate = tf_view_date.getText();
                String newMemo = ta_view_memo.getText();

                selectedMemo.setDate(newDate);
                selectedMemo.setInformation(newMemo);

                memoDAO dao = new memoDAO(MyBatisConnectionFactory.getSqlSessionFactory());
                dao.updateMemo(selectedMemo);

                tv_memo.refresh();

                tf_view_date.clear();
                ta_view_memo.clear();

                // Refresh the memo list
                refreshMemoList();
            }
        }

        @FXML
        void deleteMemo(ActionEvent event) {
            memoDTO selectedMemo = tv_memo.getSelectionModel().getSelectedItem();
            if (selectedMemo != null) {
                memoDAO dao = new memoDAO(MyBatisConnectionFactory.getSqlSessionFactory());
                dao.deleteMemo(selectedMemo.getId());

                tv_memo.getItems().remove(selectedMemo);
            }
        }

        // 메모 목록을 불러와 TableView에 표시합니다.
    }
