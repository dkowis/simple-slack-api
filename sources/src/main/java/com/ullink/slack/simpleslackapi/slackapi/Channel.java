package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

@Data
public class Channel {
    private String id;
    private String name;
    private long created; //TODO: timestamp!
    private String creator; //TODO: slack user details
}
