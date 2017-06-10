package com.ullink.slack.simpleslackapi.slackapi.parsing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

@Slf4j
public final class SlackApiParser {
    public final static SlackApiParser INSTANCE = new SlackApiParser();

    private final Object lock = new Object();
    private ObjectMapper objectMapper;

    private SlackApiParser() {
        //Only exists to thwart a second instantiation
    }

    public ObjectMapper mapper() {
        synchronized (lock) {
            //Get the mapper, or create it
            if (this.objectMapper == null) {
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

                //This module has overrides that we might want
                mapper.registerModule(module8);

                this.objectMapper = mapper;
            }
        }
        return objectMapper;
    }
}
