package tata.mybackup.filefinder;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;
import tata.mybackup.json.Config;

import static tata.mybackup.DataManager.FindFileExist;


/**
 * Created by Sonia on 2017/10/18.
 */

public class LocalFileFinder extends AbstractFileFinder{
    private static String TAG = LocalFileFinder.class.getSimpleName();


    public LocalFileFinder(Config config)
    {
        this.config = config;
        if (config.SubDirectory.equals("true"))
            this.files = this.GetSubDirectoryFiles(config);
        else
            this.files = FindFileExist(config.Location, "." + config.Ext);
        MyBackApplication.toLog(TAG,"Location = " + config.Location);
        MyBackApplication.toLog(TAG,"Ext = "  + config.Ext );
    }

    private List<String> GetSubDirectoryFiles(Config config)
    {
        File files = new File(Environment.getExternalStorageDirectory(),"/" +  config.Location);
        File[] names = files.listFiles();
        List<String> FileName = new ArrayList<String>();
        List<String> Name = new ArrayList<String>();
        FileName = FindFileExist(config.Location, "." + config.Ext);
        String folder = "";
        for(int i = 0 ; i < names.length ; i++)
        {
            if(names[i].isDirectory()) {
                folder = names[i].toString().replace(Environment.getExternalStorageDirectory().toString() + "/", "");
                Name = FindFileExist(folder, "." + config.Ext);
                if (Name.size() > 0) {
                    for (int j = 0; j < Name.size(); j++) {
                        FileName.add("/" + folder.replace(config.Location + "/", "") + "/" + Name.get(j));
                        MyBackApplication.toLog(TAG, "Name =" + FileName.get(FileName.size() - 1));
                    }
                }
            }
        }
        return FileName;
    }

    public Candidate createCandidate(String fileName) {
        Candidate candidate = new Candidate();
        candidate.Name = fileName;
        candidate.config = config;
        current = candidate;
        return candidate;
    }
}
