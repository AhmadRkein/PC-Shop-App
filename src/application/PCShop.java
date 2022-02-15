package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.StageStyle;
import models.CPU;
import models.DBModel;
import models.ProductFactory;
import models.users.CurrentUser;
import models.users.User;


public class PCShop extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("../resources/views/LoginMenuView.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
