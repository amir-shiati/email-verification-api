package com.amirshiati.Emailverification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "code")
public class CodeConfig {
    private int length;
    private boolean digits;
    private boolean upper;
    private boolean lower;
    private int validForMinutes;

    public int getValidForMinutes() {
        return validForMinutes;
    }

    public void setValidForMinutes(int validForMinutes) {
        this.validForMinutes = validForMinutes;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isDigits() {
        return digits;
    }

    public void setDigits(boolean digits) {
        this.digits = digits;
    }

    public boolean isUpper() {
        return upper;
    }

    public void setUpper(boolean upper) {
        this.upper = upper;
    }

    public boolean isLower() {
        return lower;
    }

    public void setLower(boolean lower) {
        this.lower = lower;
    }
}
