package tata.mybackup.classmanager;

import java.util.ArrayList;

import tata.mybackup.DataManager;
import tata.mybackup.json.Config;


/**
 * Created by Sonia on 2017/10/18.
 */

public abstract class JsonManager {

   protected String GetJsonObject(String path){
               return DataManager.readFileFromAssets(path);
   }

   public abstract void ProcessJsonConfig();

    public abstract ArrayList<Config> FindConfig();

}
