package tata.mybackup.handler;

import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;

/**
 * Created by Sonia on 2017/10/18.
 */

public class FileHandler extends AbstractHandler{
   public  static String TAG = FileHandler.class.getSimpleName();

   @Override
   public byte[] Perform(Candidate candidate, byte[] target) {
      MyBackApplication.toLog(TAG,"FileHandler Perform");

      byte[] result = null;

      if(target == null)
         result = ConvertFileToByteArray(candidate);
      else
         result = ConvertByteArrayToFile(candidate,target);
      return result;
   }

   private byte[] ConvertFileToByteArray(Candidate candidate){
      ByteArrayOutputStream outputStream = null;
      InputStream inputStream = null;
      try {
         byte[] buffer = new byte[4096];
         outputStream = new ByteArrayOutputStream();
//         inputStream = new FileInputStream(candidate.Name);
         //測試
         inputStream = new FileInputStream(Environment.getExternalStorageDirectory() + "/input.txt");
         int read = 0;

         while ((read = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, read);
         }

      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }finally {
         try {
            if (inputStream != null)
               inputStream.close();
            if (outputStream != null)
               outputStream.close();
         } catch (IOException e) {
         }
      }
      return outputStream.toByteArray();
   }

   private byte[] ConvertByteArrayToFile(Candidate candidate,byte[] target) {
         byte[] result = null;
         return result;
   }

}
