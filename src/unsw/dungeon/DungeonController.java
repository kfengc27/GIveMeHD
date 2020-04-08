package unsw.dungeon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest, modified by Junhui, Chengbin
 *
 */
public class DungeonController {

    @FXML 
    private GridPane squares;
    
    @FXML
    private Pane mazeGamePane;
    
    @FXML
    private Pane boulderGamePane;
    
    @FXML
    private Pane advancedGamePane;
    
	@FXML
	private Pane advancedPane;
	
	@FXML
	private Button pause;
    
	private DungeonControllerLoader game; 

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;
    

    private boolean running = true; 

    private List<Enemy> enemies;


    public DungeonController() {
    	
    }
    
    /**
     * constructor
     * @param dungeon
     * @param initialEntities
     */
    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.enemies = dungeon.getEnemies();
        this.initialEntities = new ArrayList<>(initialEntities);
    }
    
    /**
     * innitialize the dungeon
     */
    @FXML
    public void initialize() {
        Image ground = new Image("/dirt_0_new.png");
        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }
        
        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);

    }

    /**
     * handle key event for players
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleKeyPress(KeyEvent event) throws IOException {
    	System.out.println("The key code is  " + event.getCode());
        switch (event.getCode()) {
        case I:
            player.moveUp();
            break;
        case K:
            player.moveDown();
            break;
        case J:
            player.moveLeft();
            break;
        case L:
            player.moveRight();
            break;
        case A:
        	player.killLeft();
        	break;
        case W:
        	player.killUp();
        	break;
        case S:
        	player.killDown();
        	break;
        case D:
        	player.killRight();
        	break;
        case SHIFT:
        	player.releaseArms();
        	break;
        case Q:
        	player.lightBomb();
        	break;
        case DIGIT1: 
        	player.changeToSword();
        	break;
        case DIGIT2: 
        	player.changeToBomb();
        	break;
        case DIGIT9:
        	player.showPlayerStatue();
        	break;
        case R:
        	this.dungeon.upSpeed();
        	System.out.println(this.dungeon.getSpeed());
        	break;
        case T:
        	this.dungeon.downSpeed();
        	break; 
        case SPACE:
        	this.dungeon.pauseGame();
        	System.out.println("The speed is " + this.dungeon.getRunning());
        default:
            break;
        }
        System.out.print(player.getSuccess());
        if(player.getSuccess()) {
 
        	if(boulderGamePane != null) {
	        	/*BoulderListController bcontroller = new BoulderListController();
	            FXMLLoader bLoader = new FXMLLoader(getClass().getResource("BoulderListView.fxml"));
	    		bLoader.setController(bcontroller);
	    		Pane bpane = bLoader.load();
	    		boulderGamePane.getChildren().setAll(bpane);*/
        		SuccessBouldersController scontroller = new SuccessBouldersController();
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuccessView.fxml"));
                loader.setController(scontroller);
                Pane pane = loader.load();
	    		boulderGamePane.getChildren().setAll(pane);
        	}
    		
        	if(mazeGamePane != null) {
	    		/*MazeListController controller = new MazeListController();
	            FXMLLoader mLoader = new FXMLLoader(getClass().getResource("mazeListView.fxml"));
	    		mLoader.setController(controller);
	    		Pane pane = mLoader.load();
	    		mazeGamePane.getChildren().setAll(pane);*/
        		SuccessMazeController scontroller = new SuccessMazeController();
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuccessView.fxml"));
                loader.setController(scontroller);
                Pane pane = loader.load();
	    		mazeGamePane.getChildren().setAll(pane);
        	}
        	
        	if(advancedGamePane != null) {
        		/*AdvancedListController controller = new AdvancedListController();
                FXMLLoader mLoader = new FXMLLoader(getClass().getResource("AdvancedListView.fxml"));
        		mLoader.setController(controller);
        		Pane pane = mLoader.load();
        		advancedGamePane.getChildren().setAll(pane);*/
        		SuccessAdvancedController scontroller = new SuccessAdvancedController();
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuccessView.fxml"));
                loader.setController(scontroller);
                Pane pane = loader.load();
	    		advancedGamePane.getChildren().setAll(pane);
        	}
        }
    }
      
    /**
     * handle back button for maze dungeon
     * @param event
     * @throws IOException
     */
	@FXML
	public void handleMBack(ActionEvent event) throws IOException{		
        MazeListController controller = new MazeListController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("mazeListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		mazeGamePane.getChildren().setAll(pane);
	}
    /**
     * handle back button for boulder dungeon
     * @param event
     * @throws IOException
     */
	@FXML
	public void handleBBack(ActionEvent event) throws IOException{		
        BoulderListController controller = new BoulderListController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("BoulderListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		boulderGamePane.getChildren().setAll(pane);
	}
    /**
     * handle back button for advanced dungeon
     * @param event
     * @throws IOException
     */
	@FXML
	public void handleABack(ActionEvent event) throws IOException{		
		System.out.println("\nThe game stop");
        AdvancedListController controller = new AdvancedListController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("AdvancedListView.fxml"));
		mLoader.setController(controller);
		Pane pane = mLoader.load();
		advancedGamePane.getChildren().setAll(pane);
	}
	

	/**
	 * handle pause for advanced dungeon
	 * @param event
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@FXML 
	public void handlePause(ActionEvent event) throws IOException, InterruptedException{
		
		if(running) {
			this.running = false; 
			pause.setText("Start");
			this.dungeon.setRunning(running);
	
		}else {
			this.running = true; 
			pause.setText("Pause");
			this.dungeon.setRunning(running);
		}
		
		System.out.println("The dungeon is " + this.dungeon.getPlayer().getName());
	}
	
	/**
	 * handle restart button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void restartButton(ActionEvent event) throws IOException{
		DungeonControllerLoader game = new DungeonControllerLoader("advanced.json");
        DungeonController controller = game.loadController();
        FXMLLoader mLoader = new FXMLLoader(getClass().getResource("AdvancedView.fxml"));
        mLoader.setController(controller);
        Pane pane = mLoader.load();
        pane.requestFocus();
        advancedPane.getChildren().setAll(pane);
		
	}
}

