package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class DndUpdated extends SlackEvent{
    @NonNull
    private String user;
    @NonNull
    private DndStatus dndStatus;
}
