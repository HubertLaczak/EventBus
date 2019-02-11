package com.example.eventbus.TypesOfMessage;

public class StickyMessage {
    private String stickyMessage;

    public StickyMessage(String stickyMessage) {
        this.stickyMessage = stickyMessage;
    }

    public String getStickyMessage() {
        return stickyMessage;
    }

    public void setStickyMessage(String stickyMessage) {
        this.stickyMessage = stickyMessage;
    }
}

