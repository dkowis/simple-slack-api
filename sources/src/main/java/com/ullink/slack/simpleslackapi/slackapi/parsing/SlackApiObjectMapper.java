package com.ullink.slack.simpleslackapi.slackapi.parsing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ullink.slack.simpleslackapi.slackapi.SlackEvent;
import com.ullink.slack.simpleslackapi.slackapi.SubMessage;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;

@Slf4j
public final class SlackApiObjectMapper {
    /**
     * Just to provide the right mapper, things that use the api can cache it however they want to.
     *
     * @return
     */
    public static ObjectMapper mapper() {
        //Get the mapper, or create it
        //Creation of this guy is kinda expensive, so singeltonize it.
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);


        //Create a custom marshaller for the OffsetDateTime
        Jackson8Module module8 = new Jackson8Module();

        //To comply with output for slack's API, we need microsecond precision output for OffsetDateTimes, and as a string
        module8.addStringSerializer(OffsetDateTime.class, val -> {
            //need to produce "1361482916.000004"
            //Needs to be 6 zero padded
            return String.format("%d.%06d", val.getLong(ChronoField.INSTANT_SECONDS), val.getLong(ChronoField.MICRO_OF_SECOND));
        });

        //Register modules in order. Last module gets the highest priority
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(SlackEvent.class, new SlackEventDeserializer(null));

        mapper.registerModule(simpleModule);

        //This module has overrides that we might want
        mapper.registerModule(module8);

        return mapper;
    }
}
