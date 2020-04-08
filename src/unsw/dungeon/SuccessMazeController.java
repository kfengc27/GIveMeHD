package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * controller for the success scene of the maze dungeon
 * @author Junhui
 *
 */
public class SuccessMazeController {
	@FXML
	public Pane successPane;

	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBackMenu(ActionEvent event) throws IOException {
		MazeListController controller = new MazeListController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("mazeListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		successPane.getChildren().setAll(pane);
		
	}
}
