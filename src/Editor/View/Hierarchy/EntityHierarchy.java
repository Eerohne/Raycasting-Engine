/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor.View.Hierarchy;

import Editor.MapEditor;
import Editor.Model.Profile.EntityProfile;
import Editor.Model.Profile.MapProfile;
import Editor.View.Metadata.EntityContent;
import Editor.Controller.ProfileController.EntityController;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author A
 */
public class EntityHierarchy extends Hierarchy{
    private MapProfile map;
    
    public EntityHierarchy() {
        super(null);
    }

    @Override
    public void refresh() {
        //TODO
        list.getChildren().clear();
        
        for (Map.Entry<Integer, EntityProfile> entry : map.getEntityMap().entrySet()) {
            HBox item = new HBox(10);
            item.setPadding(new Insets(25));
            Label name = new Label(entry.getValue().getName());
            
            Circle ec = new Circle(32, entry.getValue().getDot().getColor());

            item.setOnMouseClicked(e -> {
                select(item);
                EntityProfile ep = entry.getValue();
                EntityContent eContent = new EntityContent(ep);
                EntityController wc = new EntityController(eContent, map);
                MapEditor.setDataView(eContent);

                if(e.getButton().equals(MouseButton.PRIMARY)){
                    map.getGc().setSelectedEntityProfile(entry.getValue());
                }
            });
            item.getChildren().addAll(ec, name);
            
      
            list.setFillWidth(true);
            list.getChildren().add(item);
        }
    }

    
    public MapProfile getMapProfile(){
        return map;
    }
    
    public void setMapProfile(MapProfile map){
        this.map = map;
        this.refresh();
    }
//    public void setEntityProfile(EntityProfile profile) {
//        this.profile = profile;
//    }
    
}