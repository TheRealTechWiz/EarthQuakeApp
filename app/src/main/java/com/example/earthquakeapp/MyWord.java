package com.example.earthquakeapp;

public class MyWord {
    double mmag;
    String mloc;
    long mdate;
    String murl;

    public MyWord(double mag, String loc, long date, String url){
        mmag = mag;
        mloc = loc;
        mdate = date;
        murl = url;
    }
    public double getmag(){return mmag;}
    public String getloc(){return mloc;}
    public long getdate(){return mdate;}
    public String geturl(){return murl;}
}
