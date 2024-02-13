package com.example.springSms.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;

import com.twilio.rest.api.v2010.account.Message.Direction;
import com.twilio.rest.api.v2010.account.Message.Status;
import com.twilio.type.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {
    private String accountSid;
    private String apiVersion;
    private String body;
    private DateTime dateCreated;
    private DateTime dateSent;
    private DateTime dateUpdated;
    private Direction direction;
    private Integer errorCode;
    private String errorMessage;
    private PhoneNumber from;

    private String numMedia;
    private String numSegments;
    private BigDecimal price;
    private Currency priceUnit;
    private String sid;
    private Status status;
    private Map<String,String> subresourceUris;
    private String to;
    private String uri;


}
