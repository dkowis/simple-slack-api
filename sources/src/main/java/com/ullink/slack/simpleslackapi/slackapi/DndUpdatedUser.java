package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class DndUpdatedUser extends SlackEvent {
    private String user;
    private DndStatus dndStatus;
}
