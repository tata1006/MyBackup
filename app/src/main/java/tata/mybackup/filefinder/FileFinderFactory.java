package tata.mybackup.filefinder;

import tata.mybackup.json.Config;


/**
 * Created by Sonia on 2017/10/18.
 */

public abstract class FileFinderFactory {

        public static FileFinder Create(String finder, Config config) {
           if(finder.equals("file"))
               return new LocalFileFinder(config);
           else
               return null;
        }
}
