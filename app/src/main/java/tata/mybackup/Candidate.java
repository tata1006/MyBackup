package tata.mybackup;

import tata.mybackup.json.Config;

/**
 * Created by Sonia on 2017/10/18.
 */

public class Candidate {
    public Config config;
    public String FileDateTime; //檔案的日期與時間
    public String Name; //檔案名稱
    public String ProcessName; // 處理檔案的 process
    public String Size; // 檔案 size
}
