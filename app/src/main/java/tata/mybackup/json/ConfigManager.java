package tata.mybackup.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import tata.mybackup.DataManager;
import tata.mybackup.MyBackApplication;
import tata.mybackup.classmanager.JsonManager;

/**
 * Created by Sonia on 2017/10/18.
 */

public class ConfigManager extends JsonManager {
   private static String TAG = ConfigManager.class.getSimpleName();

   private String PATH = "config.txt";

   @SerializedName("configs")
   private ArrayList<Config> confings = new ArrayList<>();

   @Override
   public void ProcessJsonConfig() {
       String outPut =  this.GetJsonObject(PATH);
       ConfigManager configManager = DataManager.covertObj(outPut, ConfigManager.class);
      for(int i = 0; i < configManager.confings.size(); i++){
         Config config = configManager.confings.get(i);
         MyBackApplication.toLog(TAG,"Ext:" + config.Ext);
         MyBackApplication.toLog(TAG,"Location:" + config.Location);
         MyBackApplication.toLog(TAG,"SubDirectory:" + config.SubDirectory);
         MyBackApplication.toLog(TAG,"Unit:" + config.Unit);
         MyBackApplication.toLog(TAG,"Remove:" + config.Remove);
         MyBackApplication.toLog(TAG,"Handler:" + config.Handler);
         MyBackApplication.toLog(TAG,"Destination:" + config.Destination);
         MyBackApplication.toLog(TAG,"Dir:" + config.Dir);
         MyBackApplication.toLog(TAG,"ConnectionString:" + config.ConnectionString);
         confings.add(config);
      }
   }

   @Override
   public Config FindConfig(String file_ext) {
      for(int i = 0; i < confings.size(); i++) {
         if(confings.get(i).Ext.equals(file_ext)) {
            return confings.get(i);
         }
      }
      return null;
   }
}
