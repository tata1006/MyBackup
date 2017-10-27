package tata.mybackup.classmanager;

import tata.mybackup.DataManager;


/**
 * Created by Sonia on 2017/10/18.
 */

public abstract class JsonManager {

   protected String GetJsonObject(String path){
               return DataManager.readFileFromAssets(path);
   }

   public abstract void ProcessJsonConfig();
}
