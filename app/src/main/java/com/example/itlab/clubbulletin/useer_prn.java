package com.example.itlab.clubbulletin;

/**
 * Created by IT lab on 21-Apr-17.
 */

public class useer_prn {
    public static String user_prn;
    public void setUser_prn(String user_prn){
        this.user_prn = user_prn;
    }
    public String getUser_prn(){
        return user_prn;
    }
    public boolean check_sait(){
        if(user_prn.equals("SAIT")){
            return true;
        }
        return false;
    }
    public boolean check_elesa(){
        if(user_prn.equals("ELESA")){
            return true;
        }
        return false;
    }
    public boolean check_eesa(){
        if(user_prn.equals("EESA")){
            return true;
        }
        return false;
    }
    public boolean check_acses(){
        if(user_prn.equals("ACSES")){
            return true;
        }
        return false;
    }
    public boolean check_mesa(){
        if(user_prn.equals("MESA")){
            return true;
        }
        return false;
    }
    public boolean check_cesa(){
        if(user_prn.equals("CESA")){
            return true;
        }
        return false;
    }

}
