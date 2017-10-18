package tata.mybackup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import tata.mybackup.json.Config;
import tata.mybackup.json.ConfigManager;
import tata.mybackup.json.Schedule;
import tata.mybackup.json.ScheduleManager;


public class MainActivity extends Activity {
    //檔案名稱
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //輸出資料
        String outPut = "";

        //讀取config.txt
        outPut = DataManager.readFileFromAssets(this,"config.txt");
        ConfigManager configManager = DataManager.covertObj(outPut, ConfigManager.class);
        for(int i = 0; i < configManager.confings.size(); i++){
            Config config = configManager.confings.get(i);
            Log.d(TAG,"Ext:" + config.Ext);
            Log.d(TAG,"Location:" + config.Location);
            Log.d(TAG,"SubDirectory:" + config.SubDirectory);
            Log.d(TAG,"Unit:" + config.Unit);
            Log.d(TAG,"Remove:" + config.Remove);
            Log.d(TAG,"Handler:" + config.Handler);
            Log.d(TAG,"Destination:" + config.Destination);
            Log.d(TAG,"Dir:" + config.Dir);
            Log.d(TAG,"ConnectionString:" + config.ConnectionString);
        }

        //讀取Schedule.txt
        outPut = DataManager.readFileFromAssets(this,"schedule.txt");
        ScheduleManager scheduleManager = DataManager.covertObj(outPut, ScheduleManager.class);
        for(int i = 0; i < scheduleManager.schedules.size(); i++){
            Schedule schedule = scheduleManager.schedules.get(i);
            Log.d(TAG,"Ext:" + schedule.Ext);
            Log.d(TAG,"Time:" + schedule.Time);
            Log.d(TAG,"Interval:" + schedule.Interval);
        }
    }
}
