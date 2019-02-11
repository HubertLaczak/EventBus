package com.example.eventbus.TypesOfMessage;

public class MessageEvent {
    private String customMessage;

    public MessageEvent(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}
