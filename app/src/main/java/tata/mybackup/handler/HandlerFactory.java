package tata.mybackup.handler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import tata.mybackup.DataManager;

/**
 * Created by Sonia on 2017/10/18.
 */

public class HandlerFactory {
   private static String TAG = HandlerFactory.class.getSimpleName();

   private static Map<String, String> handlerDictionary;

   public static void HandlerFactory() {
      String outPut = DataManager.readFileFromAssets("handler_mapping.txt");
      Gson gson = new Gson();
      Type type = new TypeToken<Map<String, String>>() {}.getType();
      handlerDictionary = gson.fromJson(outPut, type);
   }

   public static Handler Create(String key) {
      String value = handlerDictionary.get(key);
      if(value != null) {
         if (value.equals(FileHandler.TAG))
            return new FileHandler();
         else if (value.equals(EncodeHandler.TAG))
            return new EncodeHandler();
         else if (value.equals(ZipHandler.TAG))
            return new ZipHandler();
         else if (value.equals(DirectoryHandler.TAG))
            return new DirectoryHandler();
      }
      return null;
   }
}
