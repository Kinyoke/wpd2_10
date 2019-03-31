package net.wpd2_coursework_group10.controller;


import net.wpd2_coursework_group10.model.Topic;

import java.util.ArrayList;

public class MessageBoard {

    private ArrayList<Topic> Topics;

    private String messageBoardTitle;

    public MessageBoard(String title){

        this.messageBoardTitle = title;

        this.Topics = new ArrayList<Topic>();
    }

    public void setMessageBoardTitle(String title) { this.messageBoardTitle = title; }

    public String getMessageBoardTitle() { return this.messageBoardTitle; }

    public void addTopics(Topic topic) { this.Topics.add(topic); }

    public Topic getTopics(int index) { return this.Topics.get(index); }

    public int getNumberOfTopics() { return this.Topics.size(); }

    public void deleteTopic(int index) { this.Topics.remove(index); }

    public void display(){

        for (int i = 0; i < this.Topics.size(); i++){
            System.out.println(String.format("%d:  %s", i+1, this.Topics.get(i).getTopicDescription().toString()));
        }
    }


}

