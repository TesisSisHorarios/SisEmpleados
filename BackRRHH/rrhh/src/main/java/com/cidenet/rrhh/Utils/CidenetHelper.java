package com.cidenet.rrhh.Utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CidenetHelper {
    public static Timestamp getFhasta(){
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt_1 = objSDF.parse("2999-12-31 00:00:00");
            Timestamp fhasta =new Timestamp(dt_1.getTime());
            return fhasta;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
