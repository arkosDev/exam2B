package com.iarcos.b2.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iarcos.b2.util.FecAdapt;

@Configuration
public class GsonConfig {

    @Bean
    Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new FecAdapt())
                .create();
    }

    @Bean
    HttpMessageConverter<Object> gsonHttpMessageConverter(Gson gson) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }
}
