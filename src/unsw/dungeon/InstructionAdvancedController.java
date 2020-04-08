package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * the controller for instruction scene in the advanced dungeon
 * @author Junhui
 *
 */
public class InstructionAdvancedController {
	@FXML
	private Pane instructionPane;
	
	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleInstructionBack(ActionEvent event) throws IOException {
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("advanced.json");

        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("AdvancedView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        instructionPane.getChildren().setAll(pane);	
	}

}
