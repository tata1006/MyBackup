package tata.mybackup.classmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;
import tata.mybackup.handler.Handler;
import tata.mybackup.handler.HandlerFactory;
import tata.mybackup.json.Config;
import tata.mybackup.json.ConfigManager;
import tata.mybackup.json.ScheduleManager;

/**
 * Created by Sonia on 2017/10/18.
 */

public class MyBackupService {
    private static String TAG = MyBackupService.class.getSimpleName();

    public ArrayList<JsonManager> jsonManagers= null;

    public void ProcessJsonConfig(){
        jsonManagers = new ArrayList<JsonManager>();
        jsonManagers.add(new ConfigManager());
        jsonManagers.add(new ScheduleManager());

        for(int i = 0 ; i < jsonManagers.size(); i++){
            jsonManagers.get(i).ProcessJsonConfig();
        }
    }

    public void DoBackup() {
          //Homework 4
        ArrayList<Candidate> candidates = this.FindFiles();

        for(int i = 0 ; i < candidates.size(); i++){
            MyBackApplication.toLog(TAG, "Ext:" + candidates.get(i).config.Ext);
            BroadcastToHandlers(candidates.get(i));
        }
    }

    private ArrayList<Candidate> FindFiles(){
        ArrayList<Candidate> candidates = new ArrayList<>();
        Candidate candidate = null;
        Config config = null;


        // Homework 4
        //測試
        ArrayList<String> file_ext = new ArrayList(Arrays.asList("cs", "DOCX", "jpg"));

        for(int i = 0 ; i < file_ext.size() ; i++) {
            candidate = new Candidate();

            for (int j = 0; j < jsonManagers.size(); j++) {
                config = null;
                if (jsonManagers.get(j).FindConfig(file_ext.get(i)) != null) {
                    config = jsonManagers.get(j).FindConfig(file_ext.get(i));
                    break;
                }
            }

            candidate.config = config;
            candidates.add(candidate);
        }
        return candidates;
    }

    private void BroadcastToHandlers(Candidate candidate) {

        List<Handler> handlers = FindHandlers(candidate);
        byte[] target = null;

        for (int i = 0; i < handlers.size(); i++)
            target = handlers.get(i).Perform(candidate, target);
    }

    private ArrayList<Handler> FindHandlers(Candidate candidate) {
        ArrayList<Handler> handlers = new ArrayList<Handler>() ;
        HandlerFactory handlerFactory = new HandlerFactory();
        handlerFactory.HandlerFactory();

        handlers.add(handlerFactory.Create("file"));

        for(int i = 0 ; i < candidate.config.Handler.size(); i++) {
            if(handlerFactory.Create(candidate.config.Handler.get(i)) != null)
                handlers.add(handlerFactory.Create(candidate.config.Handler.get(i)));
        }

//        String config_destination =  "";
//        for(int i = 0 ; i < jsonManagers.size(); i++)
//            config_destination = jsonManagers.get(i).FindDestination(candidate);

        handlers.add(HandlerFactory.Create("directory"));

        return handlers;
    }
}
