package tata.mybackup;

import android.content.res.AssetManager;
import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sonia on 2017/10/18.
 */

public class DataManager {
    private static String TAG = DataManager.class.getSimpleName();


    public static String readFileFromAssets(String fileName) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            if (null == MyBackApplication.getContext() || null == fileName) return null;
            AssetManager am =  MyBackApplication.getContext().getAssets();
            InputStream input = am.open(fileName);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            output.close();
            input.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            MyBackApplication.toLog(TAG,"Failed to readFileFromAssets:" + e.toString());
            e.printStackTrace();
            return output.toString();
        }
        return output.toString();
    }

    public static <T> T covertObj(String content, Class<T> classOfT) {
        Gson gson = new Gson();
        T obj = null;
        try {
            obj = gson.fromJson(content, classOfT);
        } catch (JsonSyntaxException e) {
            MyBackApplication.toLog(TAG,"Failed to convert gson:" + e.toString());
            e.printStackTrace();
        }
        return obj;
    }

    //搜尋已下載檔案
    public static List<String> FindFileExist(String path,String ext) {
        List<String> FileName = new ArrayList<String>();
        File rootFile = new File(Environment.getExternalStorageDirectory(),"/" +  path);
        MyBackApplication.toLog(TAG,"Folder = " + Environment.getExternalStorageDirectory() + "/" +  path);
        if (rootFile.exists() && rootFile.isDirectory()){
            File[] the_Files = rootFile.listFiles() ;
            for (File tempF : the_Files) {
                try {
                    if (tempF.getName().indexOf(ext) > -1) {
						 MyBackApplication.toLog(TAG, "FileName:" + tempF.getName());
                         FileName.add(tempF.getName());
                    }
                } catch (Exception e) {
                }
            }
        }else
            rootFile.mkdir();
        return FileName;
    }
}
