package tata.mybackup.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sonia on 2017/10/18.
 */

public class ConfigManager {
   @SerializedName("configs")
   public List<Config> confings;
}
