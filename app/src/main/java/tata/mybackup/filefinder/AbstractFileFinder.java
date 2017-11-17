package tata.mybackup.filefinder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;
import tata.mybackup.json.Config;

/**
 * Created by Sonia on 2017/10/18.
 */

public abstract class AbstractFileFinder implements FileFinder{
    private static String TAG = AbstractFileFinder.class.getSimpleName();

    protected Config config;
    protected List<String> files = new ArrayList<String>();
    protected int index =  -1;
    public Candidate current = null;

    @Override
    public Iterator iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        MyBackApplication.toLog(TAG,"size =" + files.size());
        if(files.size() > 0 && index < (files.size() - 1))
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
       if(++index < files.size())
           return createCandidate(files.get(index));
       else
           return null;
    }

    @Override
    public void remove() {
           index = -1;
           files.clear();
    }

    public abstract Candidate createCandidate(String fileName);
}
