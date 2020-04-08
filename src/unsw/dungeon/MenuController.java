package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * the controller that controls the menu scene
 * @author Junhui
 *
 */
public class MenuController {
	@FXML
	private Pane menuPane;
	
	/**
	 * handle the maze button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleMaze(ActionEvent event) throws IOException{
		System.out.println("Maze");
        MazeListController controller = new MazeListController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("mazeListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		menuPane.getChildren().setAll(pane);
		
	}
	
	/**
	 * handle the boulder button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder(ActionEvent event) throws IOException{
		System.out.println("Boulder");
        BoulderListController controller = new BoulderListController();
        FXMLLoader bLoader = new FXMLLoader(getClass().getResource("BoulderListView.fxml"));
		bLoader.setController(controller);
		Pane pane = bLoader.load();
		menuPane.getChildren().setAll(pane);
		
	}
	
	/**
	 * handle the advanced button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleAdvanced(ActionEvent event) throws IOException{
		System.out.println("Advanced");
        AdvancedListController controller = new AdvancedListController();
        FXMLLoader aLoader = new FXMLLoader(getClass().getResource("AdvancedListView.fxml"));
		aLoader.setController(controller);
		Pane pane = aLoader.load();
		menuPane.getChildren().setAll(pane);
	}
	
	/**
	 * handle the back button
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
		menuPane.getChildren().setAll(pane);
	}
	
	/**
	 * handle the instruction button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleInstruction(ActionEvent event) throws IOException{
		InstructionMenuController controller = new InstructionMenuController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("InstructionView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		pane.requestFocus();
		menuPane.getChildren().setAll(pane);
	}
}
