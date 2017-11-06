package tata.mybackup.handler;

import android.util.Base64;

import tata.mybackup.Candidate;
import tata.mybackup.MyBackApplication;

/**
 * Created by Sonia on 2017/10/18.
 */

public class EncodeHandler extends AbstractHandler{
   public static String TAG = EncodeHandler.class.getSimpleName();

   @Override
   public byte[] Perform(Candidate candidate, byte[] target) {
      MyBackApplication.toLog(TAG,"EncodeHandler Perform");

      byte[] result = null;

      if(target != null)
         result = EncodeData(candidate,target);

      return result;
   }

   private byte[] EncodeData(Candidate candidate,byte[] target) {
      return Base64.encode( target,Base64.DEFAULT);
   }

}
