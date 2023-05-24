package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.MyBatisConnectionFactory;
import persistence.dao.userDAO;
import persistence.dto.userDTO;



public class SignUp
{

    @FXML
    private TextField tf_id;

    @FXML
    private PasswordField pf_passwd;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_phone;

    @FXML
    private MenuButton mb_gender;

    @FXML
    private MenuItem mi_male;

    @FXML
    private MenuItem mi_female;

    @FXML
    private Button btn_sign_up;

    @FXML
    private DatePicker dp_birth;

    @FXML
    private Text t_result;

    @FXML
    private Button btn_back;



    // 성별 선택
    @FXML
    void setFemale(ActionEvent event)
    {
        mb_gender.setText(mi_female.getText());
    }

    @FXML
    void setMale(ActionEvent event)
    {
        mb_gender.setText(mi_male.getText());
    }
    @FXML
    void backMain(ActionEvent event) {
        loadPage("Login");
    }

    public void loadPage(String file_name)
    {
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
    void trySignUp(ActionEvent event)
    {

        userDTO user = new userDTO();

        userDAO user2 = new userDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        t_result.setText("");
        user.setLogId(tf_id.getText());
        user.setLogPw(pf_passwd.getText());
        user.setName(tf_name.getText());
        user.setDigit(tf_phone.getText());
        user.setBirth(dp_birth.getValue());
        user.setAuth(1);

        int gender;
        // 성별에 따라 gender 값 세팅
        if (mb_gender.getText().equals("남"))
            gender = 1;
        else
            gender = 0; //0 이 여자

        user.setSex(gender);
        user.setNickname("테스트닉네임");
        user2.SignUp(user);
        //이 밑에 회원가입끝나고 "회원가입 완료" 뜬 후 확인버튼 누르면 메인화면으로 돌아갸야함
    }
}
