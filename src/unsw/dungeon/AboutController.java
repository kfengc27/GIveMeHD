package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * the controller of the about scene
 * @author Junhui
 *
 */
public class AboutController {
	@FXML
	private Pane aboutPane;
	
	/**
	 * to handle the back button in the about page
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBack(ActionEvent event) throws IOException{
		System.out.println("back");
		
        StartController controller = new StartController();
        FXMLLoader sLoader = new FXMLLoader(getClass().getResource("StartView.fxml"));
		sLoader.setController(controller);
		Pane pane = sLoader.load();
		aboutPane.getChildren().setAll(pane);
	}
}
