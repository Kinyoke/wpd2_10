package net.wpd2_coursework_group10.model;


public class Payload {

    private String ACTION;

    private String APP_VERSION;

    private String CLIENT_ID;

    private String ORIGIN;

    private String SERVICE;

    private String UUID;


//    private Object DATA;


    public String getACTION() {
        return ACTION;
    }

    public String getAPP_VERSION() {
        return APP_VERSION;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public String getORIGIN() {
        return ORIGIN;
    }

    public String getSERVICE() {
        return SERVICE;
    }

    public String getUUID() {
        return UUID;
    }


//    public Object getPAYLOAD_DATA() {
//        return DATA;
//    }

    @Override
    public String toString() {
        return new StringBuffer("ACTION : ").append(this.ACTION).append("APP_VERSION : ").append(this.APP_VERSION).append("CLIENT_ID : ").append(this.CLIENT_ID).append("ORIGIN : ").append(this.ORIGIN	).append("SERVICE : ").append(this.SERVICE).append("UUID : ").append(this.UUID).toString();
    }
}
