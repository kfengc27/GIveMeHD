package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A controller that controls the the start scene
 * @author Junhui
 *
 */
public class StartController {
	@FXML
	private Pane paneStart;
	
	@FXML
	private Button exitButton;

	/**
	 * this class will handle the start button in the start scene
	 * if the start button is clicked, the menu pane will appear in the same scene
	 * @param event the mouse click event
	 * @throws IOException
	 */
	@FXML
	public void handleStart(ActionEvent event) throws IOException {
		System.out.println("start");
		
        MenuController controller = new MenuController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		pane.requestFocus();
		paneStart.getChildren().setAll(pane);
	}	
	/**
	 * handle the about button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleAbout(ActionEvent event) throws IOException {
		AboutController controller = new AboutController();
		FXMLLoader mLoader = new FXMLLoader(getClass().getResource("AboutView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		pane.requestFocus();
		paneStart.getChildren().setAll(pane);
	}
	
	/**
	 * handle the exit button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleExit(ActionEvent event) throws IOException {
		Stage stage = (Stage) exitButton.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * handle the instruction button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleInstruction(ActionEvent event) throws IOException {
		
        InstructionController controller = new InstructionController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("InstructionView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		pane.requestFocus();
		paneStart.getChildren().setAll(pane);
	}

	
}
