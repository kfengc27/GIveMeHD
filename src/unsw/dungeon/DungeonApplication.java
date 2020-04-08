package unsw.dungeon;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * start the start page
 * play the background music
 * @author Robert, modified by Junhui
 *
 */
public class DungeonApplication extends Application {
	public boolean music = true;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Dungeon");
        
        URL resource = getClass().getResource("/bgm.mp3");
        MediaPlayer a =new MediaPlayer(new Media(resource.toString()));
        a.play();
        //setMusic(true);

        //DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze.json");

        //DungeonController controller = dungeonLoader.loadController();
     
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("NewDungeonView.fxml"));
        //loader.setController(controller);
        /*Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();*/
        StartController startController = new StartController();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartView.fxml"));
        loader.setController(startController);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean isMusicOn() {
    	return music;
    }
    
    public void setMusic(Boolean music) {
    	this.music = music;
    }

}
