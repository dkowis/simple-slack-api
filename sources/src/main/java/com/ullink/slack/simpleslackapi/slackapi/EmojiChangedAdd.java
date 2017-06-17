package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

@Data
public class EmojiChangedAdd extends EmojiChanged {
    @NonNull
    private final String name;
    @NonNull
    private final String value;
}
