package com.exersaise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Contacts {

    private Long id;
    private Long userId;
    private Long phoneNumber;
    private String email;
    private String city;
    private String country;
    private String street;
    private Integer houseNumber;
    private Integer flat;
    private Timestamp created;
    private Timestamp changed;
    private Boolean deleted;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
