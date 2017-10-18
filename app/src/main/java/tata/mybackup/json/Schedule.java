package tata.mybackup.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sonia on 2017/10/18.
 */

public class Schedule {
    @SerializedName("ext")
    public String Ext;
    @SerializedName("time")
    public String Time;
    @SerializedName("interval")
    public String Interval;
}
