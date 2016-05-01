package com.codetron.wallet.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by josetesan on 1/05/16.
 */
@Configuration
public class WebSecurityConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .antMatcher("/wallet")
                .authorizeRequests().anyRequest().authenticated();
    }
}
