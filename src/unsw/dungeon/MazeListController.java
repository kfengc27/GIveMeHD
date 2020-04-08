package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * the controller for maze menu
 * @author Junhui
 *
 */
public class MazeListController {
	@FXML
	private Pane mazePane;
	
	/**
	 * handle maze1button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleMaze1(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze.json");

        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MazeView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        mazePane.getChildren().setAll(pane);
	}
	/**
	 * handle maze2button
	 * @param event
	 * @throws IOException
	 */
	public void handleMaze2(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze2.json");

        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MazeView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        mazePane.getChildren().setAll(pane);
	}
	/**
	 * handle back button
	 * @param event
	 * @throws IOException
	 */	
	@FXML
	public void handleMazeBack(ActionEvent event) throws IOException{
		System.out.println("back");
		
        MenuController controller = new MenuController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		mazePane.getChildren().setAll(pane);
	}
}
