package com.amirshiati.Emailverification.helper;

import com.amirshiati.Emailverification.config.CodeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

@Component
public class CodeGeneratorHelper {
    private final CodeConfig config;

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits = "0123456789";

    private final Random random = new SecureRandom();
    private final char[] symbols;
    private final char[] buf;

    @Autowired
    public CodeGeneratorHelper(CodeConfig config) {
        this.config = config;
        if (this.config.getLength() < 1) throw new IllegalArgumentException();
        if (getSymbols().length < 2) throw new IllegalArgumentException();
        this.symbols = getSymbols();
        this.buf = new char[this.config.getLength()];
    }

    public String getCode() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    private char[] getSymbols() {
        String allowedSymbols = "";
        if (config.isDigits())
            allowedSymbols += digits;
        if (config.isLower())
            allowedSymbols += lower;
        if (config.isUpper())
            allowedSymbols += upper;

        return allowedSymbols.toCharArray();
    }
}
