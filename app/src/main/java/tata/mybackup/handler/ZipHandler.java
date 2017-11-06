package tata.mybackup.handler;

import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;

import static android.R.id.input;

/**
 * Created by Sonia on 2017/10/18.
 */

public class ZipHandler extends AbstractHandler{
   public static String TAG = ZipHandler.class.getSimpleName();


   @Override
   public byte[] Perform(Candidate candidate, byte[] target) {
      MyBackApplication.toLog(TAG,"ZipHandler Perform");

      byte[] result = null;

      if(target != null)
         result = ZipData(candidate,target);

      return result;
   }

   private byte[] ZipData(Candidate candidate,byte[] target) {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
   //         ZipEntry entry = new ZipEntry(candidate.Name);
            //測試
            ZipEntry entry = new ZipEntry(Environment.getExternalStorageDirectory() + "/input.txt");
            entry.setSize(target.length);
            zipOutputStream.putNextEntry(entry);
            zipOutputStream.write(input);
            zipOutputStream.closeEntry();
            zipOutputStream.close();
      } catch (IOException e) {
            e.printStackTrace();
      }
      return outputStream.toByteArray();
   }
}
