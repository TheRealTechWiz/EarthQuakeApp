package com.example.earthquakeapp;

public class MyWord {
    double mmag;
    String mloc;
    long mdate;

    public MyWord(double mag, String loc, long date){
        mmag = mag;
        mloc = loc;
        mdate = date;
    }
    public double getmag(){return mmag;}
    public String getloc(){return mloc;}
    public long getdate(){return mdate;}
}
