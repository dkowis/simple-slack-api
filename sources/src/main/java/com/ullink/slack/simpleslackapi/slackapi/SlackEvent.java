package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

import java.util.Optional;

@Data
public abstract class SlackEvent {
    //The type property is consumed only to produce the actual type, nothing else.
    //Easier to make these getter/setter-able rather than to go implement supers on all subtypes
    private String type;
    private Optional<String> subtype;

}
