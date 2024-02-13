package com.example.springSms.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twilio.rest.api.v2010.account.Message.Status;
import com.twilio.type.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
		private String sid;
	    
	    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss Z")
	    private DateTime dateCreated;
	    
	    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss Z")
	    private DateTime dateUpdated;
	    
	    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss Z")
	    private DateTime dateSent;
	    
	    private String accountSid;
	    private String to;
	    private PhoneNumber from;
	    private String body;
	    private Status status;

	    private String apiVersion;
	    private BigDecimal price;
	    private String uri;
}
