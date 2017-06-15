package com.ullink.slack.simpleslackapi.slackapi.core;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
public class File {
    @NonNull
    private final String id;
    @NonNull
    private final Long created;
    @NonNull
    private final Long timestamp;
    @NonNull
    private final String name;
    @NonNull
    private final String title;
    @NonNull
    private final String mimetype; //TODO: could be an enumeration...?
    @NonNull
    private final String filetype;
    @NonNull
    private final String prettyType;
    @NonNull
    private final String user;
    @NonNull
    private final String mode;
    @NonNull
    private final Boolean editable;
    @NonNull
    private final Boolean isExternal;
    @NonNull
    private final Optional<String> externalType;
    @NonNull
    private final Long size;
    @NonNull
    private final List<String> channels;
    @NonNull
    private final List<String> groups;
    @NonNull
    private final List<String> ims;
    //TODO: initial_comment -- message format?
    @NonNull
    private final Integer numStars;
    @NonNull
    private final Boolean isStarred;
    @NonNull
    private final List<String> pinnedTo;
    @NonNull
    private final List<Reaction> reactions;
    @NonNull
    private final Integer commentsCount;

    //Apparently the file object can have any myriad of random fields attached to it :(
    @JsonIgnore
    private final Map<String, Object> additionalFields = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> otherFields() {
        return additionalFields;
    }

    @JsonAnySetter
    public void setOtherField(String name, Object value) {
        additionalFields.put(name, value);
    }
}
