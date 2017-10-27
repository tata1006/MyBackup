package tata.mybackup.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tata.mybackup.DataManager;
import tata.mybackup.MyBackApplication;
import tata.mybackup.classmanager.JsonManager;

/**
 * Created by Sonia on 2017/10/18.
 */

public class ScheduleManager extends JsonManager {
   private static String TAG = ScheduleManager.class.getSimpleName();

   private String PATH ="schedule.txt";

   @SerializedName("schedules")
   private List<Schedule> schedules;

   @Override
   public void ProcessJsonConfig() {
      String outPut =  this.GetJsonObject(PATH);
      ScheduleManager scheduleManager = DataManager.covertObj(outPut, ScheduleManager.class);
      for(int i = 0; i < scheduleManager.schedules.size(); i++){
         Schedule schedule = scheduleManager.schedules.get(i);
         MyBackApplication.toLog(TAG,"Ext:" + schedule.Ext);
         MyBackApplication.toLog(TAG,"Time:" + schedule.Time);
         MyBackApplication.toLog(TAG,"Interval:" + schedule.Interval);
      }
   }
}
