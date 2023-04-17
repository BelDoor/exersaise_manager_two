package com.exercise.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("google.servers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoogleProperties {
    String port;

    String name;

    @Override
    public String toString(){
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
