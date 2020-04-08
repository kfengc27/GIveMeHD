package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * the controller for menu scene
 * @author Junhui
 *
 */
public class InstructionMenuController {
	@FXML
	private Pane instructionPane;
	
	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleInstructionBack(ActionEvent event) throws IOException {

        MenuController controller = new MenuController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        instructionPane.getChildren().setAll(pane);	
	}

}
