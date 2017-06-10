package com.ullink.slack.simpleslackapi.slackapi.core;

import lombok.Data;

@Data
public class Topic {
    private String value;
    private String creator; //TODO: slack user ID
    private long lastSet; //TODO: timestamp (but not high precision...)
}
