package com.ullink.slack.simpleslackapi.slackapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

@Data
public class AttachmentField {
    private final String title;
    private final String value;

    //Stupid reserved words!
    @JsonProperty(value = "short")
    private final Optional<Boolean> isShort;
}
