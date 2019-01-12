package com.ybinsure.auth.util;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class HttpRequestUtils {

    public static Optional<String> readBody(HttpServletRequest httpServletRequest) {
        try {
            return Optional.ofNullable(IOUtils.toString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
