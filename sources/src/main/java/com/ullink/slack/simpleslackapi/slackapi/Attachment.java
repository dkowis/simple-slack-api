package com.ullink.slack.simpleslackapi.slackapi;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Data
public class Attachment {
    private final String fallback;
    private final String color;
    private final Optional<String> pretext;
    private final Optional<String> authorName;
    private final Optional<String> authorLink;
    private final Optional<String> authorIcon;
    private final Optional<String> title;
    private final Optional<String> titleLink;
    private final Optional<String> text;
    private final List<AttachmentField> fields = Collections.emptyList();
    private final Optional<String> imageUrl;
    private final Optional<String> thumbUrl;
    private final Optional<String> footer;
    private final Optional<String> footerIcon;
    private final Optional<Long> ts;


}
