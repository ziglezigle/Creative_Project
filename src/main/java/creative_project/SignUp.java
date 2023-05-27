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
        try
        {
            t_result.setText("");
            String id = tf_id.getText();
            String passwd = pf_passwd.getText();
            String name = tf_name.getText();
            String phone_number = tf_phone.getText();
            String birth = dp_birth.getValue().toString();
            String gender;

            // 성별에 따라 gender 값 세팅
            if (mb_gender.getText().equals("남"))
                gender = "1";
            else
                gender = "0"; //0 이 여자
            while (true)
            {

            }
        }
        catch (Exception e)
        {
            mainGUI.alert("회원가입 실패", "회원가입 실패! 알맞은 정보를 입력했나요?");
            e.printStackTrace();
        }
    }
}
