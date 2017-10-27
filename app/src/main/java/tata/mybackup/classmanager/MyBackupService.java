package tata.mybackup.classmanager;

import java.util.ArrayList;

import tata.mybackup.json.ConfigManager;
import tata.mybackup.json.ScheduleManager;

/**
 * Created by Sonia on 2017/10/18.
 */

public class MyBackupService {

    public ArrayList<JsonManager> jsonManagers= null;

    public void ProcessJsonConfig(){
        jsonManagers = new ArrayList<JsonManager>();
        jsonManagers.add(new ConfigManager());
        jsonManagers.add(new ScheduleManager());

        for(int i = 0 ; i < jsonManagers.size(); i++){
            jsonManagers.get(i).ProcessJsonConfig();
        }
    }
}
