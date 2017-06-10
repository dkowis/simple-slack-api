package com.ullink.slack.simpleslackapi.slackapi.core;

import lombok.Data;

@Data
public class Purpose {
    private String value;
    private String creator; //TODO: slack user id
    private long lastSet;
}
