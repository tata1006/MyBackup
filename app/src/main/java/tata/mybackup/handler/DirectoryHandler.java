package tata.mybackup.handler;

import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;

/**
 * Created by Sonia on 2017/10/18.
 */

public class DirectoryHandler extends AbstractHandler{
   public static String TAG = DirectoryHandler.class.getSimpleName();


   @Override
   public byte[] Perform(Candidate candidate, byte[] target) {
      MyBackApplication.toLog(TAG,"DirectoryHandler Perform");
      byte[] result = null;

      if(target != null)
         result = CopyToDirectory(candidate,target);

      return result;
   }

   private byte[] CopyToDirectory(Candidate candidate,byte[] target) {
      try {
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Environment.getExternalStorageDirectory()
//                    + "/"  + candidate.config.Destination + "/" + candidate.Name));
            //測試
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Environment.getExternalStorageDirectory() + "/output.txt"));
            bos.write(target);
            bos.flush();
            bos.close();
      } catch (IOException e) {
           e.printStackTrace();
      }
      return target;
   }

}
