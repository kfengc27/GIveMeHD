package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * the the controller for the game
 * @author Chengbin
 *
 */
public class GameController {
	
	
	@FXML
	private Pane advancedPane;
	
    @FXML 
    private GridPane squares;
    
    @FXML
    private Pane mazeGamePane;
    
    @FXML
    private Pane boulderGamePane;
    
    @FXML
    private Pane advancedGamePane;
	

	
	public GameController() {
		
	}
	
	

		
	@FXML
	public void handleABack(ActionEvent event) throws IOException{		
		GameController controller = new GameController();
		FXMLLoader mLoader = new FXMLLoader(getClass().getResource("AdvancedListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		advancedGamePane.getChildren().setAll(pane);
	}

		
	@FXML
	public void restartButton(ActionEvent event) throws IOException{
			
	}
}
