package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * the controller for instruction scene
 * @author Junhui 
 *
 */
public class InstructionController {
	@FXML
	private Pane instructionPane;
	
	@FXML
	private Pane paneStart;	
	
	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleInstructionBack(ActionEvent event) throws IOException {
		StartController controller = new StartController();
        FXMLLoader sLoader = new FXMLLoader(getClass().getResource("StartView.fxml"));
		sLoader.setController(controller);
		Pane pane = sLoader.load();
		instructionPane.getChildren().setAll(pane);		
	}

}
