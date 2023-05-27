package creative_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Manager_Main implements Initializable {

    public static BorderPane manager_sub_root;
    //관리자 기능 페인

    @FXML
    private BorderPane bp_manager_sub;
    //메인 보더페인

    @FXML
    private MenuButton mb_manager_function;
    //관리자 기능 선택 메뉴

    @FXML
    private MenuItem menu_add_restaurant;
    //맛집 추가

    @FXML
    private MenuItem menu_add_touristSpot;
    //관광지 추가

    @FXML
    private MenuItem menu_modify_restaurant;
    //맛집 정보 수정

    @FXML
    private MenuItem menu_modify_touristSpot;
    //관광지 정보 수정

    @FXML
    private MenuItem menu_remove_review;
    //리뷰 삭제

    @FXML
    private MenuItem menu_view_add_require;
    //추가 요청 조회

    @FXML
    private MenuItem menu_view_modify_require;
    //정보 수정 요청 조회

    @FXML
    private Button btn_logout;
    //로그아웃 버튼
    @FXML
    private ScrollPane sp_manager_main;

    public void initialize(URL arg0, ResourceBundle arg1)
    {
        manager_sub_root = bp_manager_sub;
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
    void add_restaurant(ActionEvent event) {

        loadPage("Manager_AddRestaurant");
    }

    @FXML
    void add_touristSpot(ActionEvent event) {

        loadPage("Manager_AddTouristSpot");
    }

    @FXML
    void modify_restaurant(ActionEvent event) {
        loadPage("Manager_ModifyRestaurant");
    }

    @FXML
    void modify_touristSpot(ActionEvent event) {
        loadPage("Manager_ModifyTouristSpot");
    }

    @FXML
    void remove_review(ActionEvent event) {
        loadPage("Manager_Review");
    }

    @FXML
    void view_add_require(ActionEvent event) {
        loadPage("Manager_AddRequireList");
    }

    @FXML
    void view_modify_require(ActionEvent event) {
        loadPage("Manager_ModifyRequireList");
    }

    public static void loadPage(String file_name)
    {
        try
        {
            Parent root = FXMLLoader.load(Manager_Main.class.getResource( file_name + ".fxml"));
            manager_sub_root.setCenter(root);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
