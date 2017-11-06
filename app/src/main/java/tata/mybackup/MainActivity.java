package tata.mybackup;

import android.app.Activity;
import android.os.Bundle;

import tata.mybackup.classmanager.MyBackupService;


public class MainActivity extends Activity {
    //檔案名稱
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBackupService myBackupService = new MyBackupService();
        myBackupService.ProcessJsonConfig();
        myBackupService.DoBackup();
    }
}
