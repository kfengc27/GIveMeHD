package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
/**
 * A class that control the boulder menu
 * @author Junhui
 *
 */
public class BoulderListController {
	@FXML
	private Pane boulderPane;
	
	/**
	 * handle the boulder1button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder1(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);
	}
	/**
	 * handle the boulder2button
	 * @param event
	 * @throws IOException
	 */	
	@FXML
	public void handleBoulder2(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders2.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder3button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder3(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders3.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder4button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder4(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders4.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder5button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder5(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders5.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder6button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder6(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders6.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder7button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder7(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders7.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder8button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder8(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders8.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder9button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder9(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders9.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder10button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder10(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders10.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder11button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder11(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders11.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the boulder12button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulder12(ActionEvent event) throws IOException{
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders12.json");
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        boulderPane.getChildren().setAll(pane);		
	}
	/**
	 * handle the back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBoulderBack(ActionEvent event) throws IOException{
		System.out.println("back");
		
        MenuController controller = new MenuController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		boulderPane.getChildren().setAll(pane);
	}
}
