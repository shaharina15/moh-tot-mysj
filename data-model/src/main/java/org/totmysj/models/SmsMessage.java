package org.totmysj.models;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data

public class SmsMessage
{
    private String phoneNumber;
    private String message;
}
