package com.example.earthquakeapp;

public class MyWord {
    String mmag;
    String mloc;
    String mdate;

    public MyWord(String mag, String loc, String date){
        mmag = mag;
        mloc = loc;
        mdate = date;
    }
    public String getmag(){return mmag;}
    public String getloc(){return mloc;}
    public String getdate(){return mdate;}
}
