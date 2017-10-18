package tata.mybackup.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sonia on 2017/10/18.
 */

public class Config {
    @SerializedName("connectionString")
    public String ConnectionString;
    @SerializedName("destination")
    public String Destination;
    @SerializedName("dir")
    public String Dir;
    @SerializedName("ext")
    public String Ext;
    @SerializedName("handler")
    public String Handler;
    @SerializedName("location")
    public String Location;
    @SerializedName("remove")
    public String Remove;
    @SerializedName("subDirectory")
    public String SubDirectory;
    @SerializedName("unit")
    public String Unit;
}
