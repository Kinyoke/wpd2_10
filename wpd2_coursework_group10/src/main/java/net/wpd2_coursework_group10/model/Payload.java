package net.wpd2_coursework_group10.model;


public class Payload {

    private String ACTION;

    private String APP_VERSION;

    private String CLIENT_ID;

    private Object DATA;

    private String ORIGIN;

    private String SERVICE;

    private String UUID;


    // setters

    public void setACTION(String ACTION) { this.ACTION = ACTION; }

    public void setAPP_VERSION(String APP_VERSION) { this.APP_VERSION = APP_VERSION; }

    public void setCLIENT_ID(String CLIENT_ID) { this.CLIENT_ID = CLIENT_ID; }

    public void setDATA(Object DATA) { this.DATA = DATA; }

    public void setORIGIN(String ORIGIN) { this.ORIGIN = ORIGIN; }

    public void setSERVICE(String SERVICE) { this.SERVICE = SERVICE; }

    public void setUUID(String UUID) { this.UUID = UUID; }


    // getters

    public String getACTION() {
        return ACTION;
    }

    public String getAPP_VERSION() {
        return APP_VERSION;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public Object getPAYLOAD_DATA() { return DATA; }

    public String getORIGIN() {
        return ORIGIN;
    }

    public String getSERVICE() {
        return SERVICE;
    }

    public String getUUID() {
        return UUID;
    }


    @Override
    public String toString() {
        return new StringBuffer("ACTION : ").append(this.ACTION).append(" APP_VERSION : ").append(this.APP_VERSION).append(" CLIENT_ID : ").append(this.CLIENT_ID).append(" ORIGIN : ").append(this.ORIGIN	).append(" SERVICE : ").append(this.SERVICE).append(" UUID : ").append(this.UUID).toString();
    }
}
