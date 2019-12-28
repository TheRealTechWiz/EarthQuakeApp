package com.example.earthquakeapp;

public class MyWord {
    String mmag;
    String mloc;
    long mdate;

    public MyWord(String mag, String loc, long date){
        mmag = mag;
        mloc = loc;
        mdate = date;
    }
    public String getmag(){return mmag;}
    public String getloc(){return mloc;}
    public long getdate(){return mdate;}
}
