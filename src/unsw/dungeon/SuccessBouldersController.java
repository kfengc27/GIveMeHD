package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * controller for the success scene of the boulders dungeon
 * @author Junhui
 *
 */
public class SuccessBouldersController {
	@FXML
	public Pane successPane;

	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBackMenu(ActionEvent event) throws IOException {
		BoulderListController controller = new BoulderListController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		successPane.getChildren().setAll(pane);
	}
}
