package net.wpd2_coursework_group10.model;


import java.util.Date;

public class Message {

    private String subject;

    private String body;

    private Date postedtime;


    public Message(){}

    public Message(String subject, String body, Date postedtime){

        this.subject = subject;

        this.body = body;

        this.postedtime = postedtime;
    }


    //SETTER METHODS GOES HERE

    /**
     * @param subject , takes a string argument for subject
     */

    public void setSubject(String subject){ this.subject = subject; }

    /**
     * @param body , takes a string argument representing a message body
     */

    public void setBody(String body){ this.body = body; }

    /**
     * @param postedtime , takes a date argument that represents time the
     * message was posted.
     */

    public void setPostedtime(Date postedtime){ this.postedtime = postedtime; }



    // GETTER METHODS GOES BELOW

    /**
     * @return , returns the current existing value from the subject variable that
     * represents a message subject
     */

    public String getSubject(){ return this.subject; }

    /**@return , returns the current existing value from the body variable that represents
     * a message body
     */

    public String getBody(){ return this.body; }

    /**@return , returns the current existing value from the postedtime variable that
     * represents when was the message posted.
     */

    public Date getPostedtime(){ return this.postedtime; }


}
