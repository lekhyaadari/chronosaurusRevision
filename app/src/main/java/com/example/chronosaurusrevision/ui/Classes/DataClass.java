package com.example.chronosaurusrevision.ui.Classes;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class DataClass {
    private String dataName;
    private String dataProf;
    private String dataTime;
    private String dataPlace;
    private String dataDays;
    private String dataSec;
    //private String dataImage;
    private String key;
    public Map<String, Boolean> stars = new HashMap<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DataClass(String dataName, String dataProf, String dataTime, String dataPlace, String dataDays, String dataSec) {
        this.dataName = dataName;
        this.dataProf = dataProf;
        this.dataTime = dataTime;
        this.dataPlace = dataPlace;
        this.dataDays = dataDays;
        this.dataSec = dataSec;
        //this.dataImage = dataImage;
    }

    public String getDataName() {
        return dataName;
    }

    public String getDataProf() {
        return dataProf;
    }

    public String getDataTime() {
        return dataTime;
    }

    public String getDataPlace() {
        return dataPlace;
    }

    public String getDataDays() {
        return dataDays;
    }

    public String getDataSec() {
        return dataSec;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Course", dataName);
        result.put("Professor", dataProf);
        result.put("Time", dataTime);
        result.put("Days", dataDays);
        result.put("Sec", dataSec);
        result.put("Place", dataPlace);
        result.put("stars", stars);

        return result;
    }

    //public String getDataImage() {
        //

    public DataClass() {
        //pending
    }
}
