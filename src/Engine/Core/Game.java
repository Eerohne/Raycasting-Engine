/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Core;

import Engine.Level.Level;
import Engine.Util.Time;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//Merouane Issad
//for now, discard any code written here, it's only test nonsense
public class Game extends Application{
    private static WindowManager windowManager;
    public static Scene scene;
    private static Level currentLevel;
    
    //flags
    boolean isRunning = true;
    boolean pauseActive = true;
    
    public void start(Stage stage) throws Exception {
        
        /*HashMap<String, String> properties = new HashMap<>();
        properties.put("classname", "Entity_Coin");
        Entity ent = EntityCreator.constructEntity(properties);
        ent.setActive(false);*/
        /*Entity_Player_Base player = new Entity_Player_Base("a", new Point2D(0,0), 90, 2, 5);
        Entity_Item_Coin coin = new Entity_Item_Coin("b", new Point2D(0,0), Color.YELLOW, 5);*/
        
        windowManager = new WindowManager(stage, 1280, 800);
        //give the renderer the canvas graphics context here -> renderer.setCanvasContext(windowManager.getRenderContext);
        
        //now load the initial level -> currentLevel = LevelLoader.load(path_to_level_file);
        new AnimationTimer() { //Game main loop

            @Override
            public void handle(long l) {
                if(isRunning)
                {
                    Time.update();
                    stage.setTitle("Optik Engine -> FPS : " + Integer.toString(Time.fps));
                    //update all entities in the level -> currentLevel.update();
                    //render the game -> renderer.render();

                    //test render, this would normally be in the reanderer class
                    windowManager.renderContext.clearRect(0, 0, windowManager.renderContext.getCanvas().getWidth(), windowManager.renderContext.getCanvas().getHeight());
                    windowManager.renderContext.setFill(Color.BLUE);
                    windowManager.renderContext.fillRect(0, 0, windowManager.renderContext.getCanvas().getWidth()/2, 200);
                }
            }
        }.start();
        
        scene = new Scene(windowManager, windowManager.getWidth(), windowManager.getHeight()); //set windows inside the scene
        stage.setScene(scene);
        stage.show();
    }
    
    public static Level getCurrentLevel()
    {
        return currentLevel;
    }
    
    public static WindowManager getWindowManager()
    {
        return windowManager;
    }
    
    public void pauseGame(boolean state) //true -> pause, false -> play
    {
        this.isRunning = !state;
        windowManager.setPauseMenuVisibility(state);
    }
    
    public void togglepauseGame()
    {
        pauseGame(isRunning);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
