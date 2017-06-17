package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class EmojiChangedRemove extends EmojiChanged {
    @NonNull
    private final List<String> names;
}
