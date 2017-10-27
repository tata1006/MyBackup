package tata.mybackup;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Sonia on 2017/10/18.
 */

public class MyBackApplication extends Application {
   private static String TAG = "MyBackup";

   public static Context context;

   public void onCreate() {
      super.onCreate();
      context = getApplicationContext();
   }

   public static Context getContext() {
      return context;
   }

   public static void toLog(String handle, String log) {
      Log.v(TAG, handle + "-" + log);
   }
}
