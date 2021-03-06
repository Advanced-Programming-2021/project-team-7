package Controller;

import Menus.DeckMenu;
import Model.CommonTools;
import Model.Player;
import Model.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;

    public void scoreboard(ActionEvent event) throws IOException {
        Sound.getSoundByName("button").playSoundOnce();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/score_board_view.fxml"));
        root = loader.load();
        ScoreboardController scoreboardController = loader.getController();
        scoreboardController.makeRefreshThread();
        scoreboardController.isPlayerInScoreboardMenu = true;
        scoreboardController.show(root);
        makeStage(event);
    }

    public void shop(ActionEvent event) throws IOException {
        Sound.getSoundByName("button").playSoundOnce();
        Shop shop = new Shop();
        try {
            shop.run(Player.getActivePlayer().getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent event) throws IOException {
        Sound.getSoundByName("button").playSoundOnce();
        String result = "";
        try {
            CommonTools.dataOutputStream.writeUTF("MainMenuController#logout#" + Player.getToken());
            CommonTools.dataOutputStream.flush();
            result = CommonTools.dataInputStream.readUTF();
        } catch (Exception e) {

        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(result);
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main_program_view.fxml"));
        root = loader.load();
        makeStage(event);
    }

    public void makeStage(ActionEvent event) {
        Sound.getSoundByName("button").playSoundOnce();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void newDuel(ActionEvent event) throws IOException {
        Sound.getSoundByName("button").playSoundOnce();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/duel_menu_view.fxml"));
        root = loader.load();
        makeStage(event);
    }

    public void importMenu(ActionEvent event) throws  IOException {
        Sound.getSoundByName("button").playSoundOnce();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/import_menu_view.fxml"));
        root = loader.load();
        makeStage(event);
    }

    public void profile(ActionEvent event) throws IOException {
        Sound.getSoundByName("button").playSoundOnce();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/profile_menu_view.fxml"));
        root = loader.load();
        ProfileMenuController profileMenuController = loader.getController();
        profileMenuController.show(root);
        makeStage(event);
    }

    public void deck(){
        Sound.getSoundByName("button").playSoundOnce();
        DeckMenu deckMenu = new DeckMenu();
        try {
            deckMenu.run(Player.getActivePlayer().getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
