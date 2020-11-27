/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Entity;

import Engine.Core.Exceptions.EntityCreationException;
import Engine.Entity.AbstractEntity.*;
import Engine.Entity.GameEntity.*;
import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

//Merouane Issad
public class EntityCreator { //Entity creation is defined in this class

    //Entity classname listing 
    public static Entity constructEntity(HashMap<String, Object> propertyMap) //provide a map with all needed properties, outputs an entity
    {
        Entity entity = null;
        
        if(!verifyProperties(propertyMap, "classname", "name", "active", "position"))
            return null;
        
        String classname = (String)propertyMap.get("classname");
        //entity classname list
        switch(classname) //add any new entity to this list and point to a create_Entity_... method
        {
            case "classname_of_entity_all_lowercase": //example of how to setup a new entity
                //if(verifyProperties(propertyMap, "rotation", "walkspeed", "runspeed"))
                    //entity = new Entity_Name_Of_Entity_Class(propertyMap);
                break;
            case "item_coin":
                if(verifyProperties(propertyMap, "scorepoint"))
                    entity = new Entity_Item_Coin(propertyMap);
                break;
            case "logic_counter":
                if(verifyProperties(propertyMap, "minvalue", "maxvalue", "startingvalue"))
                    entity = new Entity_Logic_Counter(propertyMap);
                break;
            case "logic_messenger":
                entity = new Entity_Logic_Messenger(propertyMap);
                break;
            case "logic_timer":
                if(verifyProperties(propertyMap, "maxtime"))
                    entity = new Entity_Logic_Timer(propertyMap);
                break;
            case "player_base":
                if(verifyProperties(propertyMap, "rotation", "walkspeed", "runspeed"))
                    entity = new Entity_Player_Base(propertyMap);
                break;
            case "sound_global":
                if(verifyProperties(propertyMap, "onstart", "loop"))
                    entity = new Entity_Sound_Global(propertyMap);
                break;
            case "sprite_decor":
                if(verifyProperties(propertyMap, "texture", "size"))
                    entity = new Entity_Decor(propertyMap);
                break;
            default:
                System.out.println(new EntityCreationException("classname '"+classname+"' is not defined"));
                entity = null;
        }
        return entity;
    }
    
    
    //verifies if all provided properties exist inside the map in case the entity data is incomplete or corrupted
    private static boolean verifyProperties(HashMap<String, Object> propertyMap, String... properties)
    {
        try {
            for(String property : properties)
            if(!propertyMap.containsKey(property)) {
                if(property.equals("classname"))
                    throw new EntityCreationException("Property '" + property + "' was not provided, entity type is unknown");
                else
                    throw new EntityCreationException("Missing requiered propertiy '"+property+"' when trying to create '" + propertyMap.get("classname")+"'");
            }
        }
        catch(EntityCreationException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
