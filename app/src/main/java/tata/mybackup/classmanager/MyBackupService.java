package tata.mybackup.classmanager;

import java.util.ArrayList;
import java.util.List;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;
import tata.mybackup.filefinder.FileFinder;
import tata.mybackup.filefinder.FileFinderFactory;
import tata.mybackup.handler.Handler;
import tata.mybackup.handler.HandlerFactory;
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
        FileFinder fileFinder = null;
        Candidate candidate = null;
        for(int i = 0 ; i < jsonManagers.size(); i++) {
            if (jsonManagers.get(i).FindConfig() != null) {
                for(int j = 0 ; j < jsonManagers.get(i).FindConfig().size();j++) {
                    fileFinder = FileFinderFactory.Create("file", jsonManagers.get(i).FindConfig().get(j));
                    while (fileFinder.hasNext()) {
                        candidate = (Candidate) fileFinder.next();
                        MyBackApplication.toLog(TAG, "Name =" + candidate.Name);
                        BroadcastToHandlers(candidate);
                    }
                }
            }
        }
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

        handlers.add(HandlerFactory.Create("directory"));

        return handlers;
    }
}
