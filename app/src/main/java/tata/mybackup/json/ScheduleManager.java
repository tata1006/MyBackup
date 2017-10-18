package tata.mybackup.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sonia on 2017/10/18.
 */

public class ScheduleManager {
   @SerializedName("schedules")
   public List<Schedule> schedules;
}
