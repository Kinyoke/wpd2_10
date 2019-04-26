package net.wpd2_coursework_group10.model;

import java.math.BigInteger;
import java.security.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AccountLog {

    private String userAccount;

    private String LoginTime;

    private String session;

    private String status;

    private static final String SALT = "@ultraisman47035$##%*&";

    // setters goes here.
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setLoginTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String loginTime = dateFormat.format(date);
        LoginTime = loginTime;
    }

    public void setSession(String session) {

        //Creating a Signature object
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest((session+SALT).getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            session = hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        this.session = session;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // getters goes here
    public String getUserAccount() {
        return userAccount;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public String getSession() {
        return session;
    }

    public String getStatus() {
        return status;
    }

}
