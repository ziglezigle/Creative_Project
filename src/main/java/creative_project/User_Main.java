package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class User_Main implements Initializable {

    public static AnchorPane user_sub_root;
    @FXML
    private AnchorPane ap_user_sub;

    @FXML
    private AnchorPane ap_user_sub_2;

    @FXML
    private Button btn_food;

    @FXML
    private Button btn_playland;

    @FXML
    private MenuItem menu_add_review;

    @FXML
    private MenuItem menu_recommend;

    @FXML
    private MenuItem menu_require_add;

    @FXML
    private MenuItem menu_require_modify;

    @FXML
    private MenuButton mb_member_function;

    @FXML
    private MenuItem menu_schedule;

    @FXML
    private ScrollPane sp_user_main;

    @FXML
    private MenuItem mn_item_review;

    @FXML
    private Button btn_go;

    @FXML
    private Button btn_logout;

    @FXML
    SplitPane sp_activity;

    public void initialize(URL arg0, ResourceBundle arg1) {
        user_sub_root = ap_user_sub;
    }

    @FXML
    void view_food(ActionEvent event) {
        loadPage("Information_food");
    }

    @FXML
    void view_playland(ActionEvent event) {
        loadPage("Information_Playland");

    }



    @FXML
    void logout(ActionEvent event) {
        openLoginWindow();
    }


    public void openLoginWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("로그인");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            // Close the current stage (User_Main.fxml)
            Stage currentStage = (Stage) btn_logout.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void add_review(ActionEvent event) {
        loadPage("Add_Review");
    }

    @FXML
    void manage_schedule(ActionEvent event) {
        loadPage("Memo");
    }

    @FXML
    void require_add(ActionEvent event) {
        loadPage("Require_Add");
    }

    @FXML
    void require_modify(ActionEvent event) {
        loadPage("Require_Modify");
    }

    @FXML
    void view_recommend(ActionEvent event) {
        loadPage("Recommendation");
    }

    // 페이지 로딩 함수
    public static void loadPage(String file_name) {
        try {
            FXMLLoader loader = new FXMLLoader(User_Main.class.getResource(file_name + ".fxml"));
            Parent root = loader.load();
            user_sub_root.getChildren().clear();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            user_sub_root.getChildren().add(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
