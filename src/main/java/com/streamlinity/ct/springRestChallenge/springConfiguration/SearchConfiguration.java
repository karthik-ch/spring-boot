package com.streamlinity.ct.springRestChallenge.springConfiguration;

import com.streamlinity.ct.springRestChallenge.api.SearchSvcInterface;
import com.streamlinity.ct.springRestChallenge.solution.SearchSvcImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;

@Configuration
@Profile("default")
public class SearchConfiguration {

    @Bean
    public SearchSvcInterface candSearch() {
        SearchSvcInterface searchBean = new SearchSvcImpl();
        searchBean.init(new File("./src/main/resources/itemPrices.json"));
        return searchBean;
    }
}

