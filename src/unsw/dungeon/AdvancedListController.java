package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
/**
 * controller of the advanced menu
 * @author Junhui, Chengbin
 *
 */
public class AdvancedListController {
	
	
	@FXML
	private Pane advancedPane;
	
	/**
	 * handle the advance1 button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleAdvanced1(ActionEvent event) throws IOException{

		InstructionAdvancedController controller = new InstructionAdvancedController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("InstructionView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		pane.requestFocus();

        advancedPane.getChildren().setAll(pane);
	}

	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleAdvancedBack(ActionEvent event) throws IOException{
		System.out.println("back");
		System.out.println("Back to the menu");
        MenuController controller = new MenuController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		advancedPane.getChildren().setAll(pane);
	}
}
