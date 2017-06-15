package com.ullink.slack.simpleslackapi.slackapi;

import com.ullink.slack.simpleslackapi.slackapi.core.File;
import lombok.Data;
import lombok.NonNull;

@Data
public class FileChange extends SlackEvent {
    @NonNull
    private final File file;
}
