package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.MyBatisConnectionFactory;
import persistence.dao.userDAO;
import persistence.dto.userDTO;

public class SignUp {

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_id_admin;

    @FXML
    private PasswordField pf_passwd;

    @FXML
    private PasswordField pf_passwd_admin;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_name_admin;


    @FXML
    private TextField tf_nickname;

    @FXML
    private TextField tf_nickname_admin;
    @FXML
    private TextField tf_phone;

    @FXML
    private TextField tf_phone_admin;
    @FXML
    private ComboBox cb_gender;

    @FXML
    private ComboBox mb_gender_admin;
    @FXML
    private MenuItem mi_male;

    @FXML
    private MenuItem mi_female;

    @FXML
    private Button btn_sign_up;

    @FXML
    private Button btn_sign_up_admin;

    @FXML
    private DatePicker dp_birth;
    @FXML
    private DatePicker dp_birth_admin;

    @FXML
    private Text t_result;


    @FXML
    private Button btn_back;

    // 성별 선택
//    @FXML
//    void setFemale(ActionEvent event) {
//        cb_gender.setText(mi_female.getText());
//    }
//
//    @FXML
//    void setMale(ActionEvent event) {
//        cb_gender.setText(mi_male.getText());
//    }

    @FXML
    void backMain(ActionEvent event) {
        loadPage("Login");
    }

    public void loadPage(String file_name) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(file_name + ".fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btn_back.getScene().getWindow(); // Get the current stage
            stage.setScene(scene); // Set the scene of the current stage
            stage.show(); // Show the updated stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원가입 시도
    @FXML
    void trySignUp(ActionEvent event) {

        userDTO user = new userDTO();

        userDAO user2 = new userDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        t_result.setText("");
        user.setLogId(tf_id.getText());


        mainGUI mainGUI = new mainGUI();

        user.setLogPw(pf_passwd.getText());
        user.setName(tf_name.getText());
        user.setDigit(tf_phone.getText());
        user.setBirth(dp_birth.getValue());
        user.setAuth(0);

        int gender;
        // 성별에 따라 gender 값 세팅
        if (cb_gender.getValue().equals("남"))
            gender = 1;
        else
            gender = 0; //0 이 여자

        user.setSex(gender);
        user.setNickname(tf_nickname.getText());
        boolean exists = user2.idTest(tf_id.getText());
        if (exists) {
            mainGUI.alert("아이디에러", "이미 같은 아이디가 존재합니다.");
        } else {
            user2.SignUp(user);
            mainGUI.alert("회원가입 완료", "회원가입이 완료되었습니다.");
            // 회원가입 완료 후 확인 버튼을 누르면 메인화면으로 돌아감
            // mainGUI 메인화면으로 돌아가는 로직을 추가해야 함
        }
    }
    @FXML
    public void trySignUpAdmin(ActionEvent event){
        userDTO user = new userDTO();

        userDAO user2 = new userDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        t_result.setText("");
        user.setLogId(tf_id_admin.getText());


        mainGUI mainGUI = new mainGUI();

        user.setLogPw(pf_passwd_admin.getText());
        user.setName(tf_name_admin.getText());
        user.setDigit(tf_phone_admin.getText());
        user.setBirth(dp_birth_admin.getValue());
        user.setNickname(tf_nickname_admin.getText());
        user.setAuth(1);

        int gender;
        // 성별에 따라 gender 값 세팅
        if (mb_gender_admin.getValue().equals("남"))
            gender = 1;
        else
            gender = 0; //0 이 여자

        user.setSex(gender);

        boolean exists = user2.idTest(tf_id_admin.getText());
        if (exists) {
            mainGUI.alert("아이디에러", "이미 같은 아이디가 존재합니다.");
        } else {
            user2.SignUp(user);
            mainGUI.alert("관리자 회원가입 완료", "회원가입이 완료되었습니다.");
            // 회원가입 완료 후 확인 버튼을 누르면 메인화면으로 돌아감
            // mainGUI 메인화면으로 돌아가는 로직을 추가해야 함
        }
    }
    }

