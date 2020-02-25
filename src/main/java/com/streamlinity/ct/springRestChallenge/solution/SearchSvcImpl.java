package com.streamlinity.ct.springRestChallenge.solution;

import com.google.gson.Gson;
import com.streamlinity.ct.springRestChallenge.api.Item;
import com.streamlinity.ct.springRestChallenge.api.SearchSvcInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Provide your implementation of the SearchSvcImpl here.
 * Also annotate your methods with Rest end point wrappers as required in the problem statement
 *
 * You can create any auxiliary classes or interfaces in this package if you need them.
 *
 * Do NOT add annotations as a Bean or Component or Service.   This is being handled in the custom Config class
 * PriceAdjustConfiguration
 */

public class SearchSvcImpl implements SearchSvcInterface {

    List<Item> listOfItems;

    @Override
    public void init(String itemPriceJsonFileName) {

    }

    @Override
    public void init(File itemPriceJsonFile) {
        try {
            Item[] items = new Gson().fromJson(new FileReader(itemPriceJsonFile), Item[].class);
            listOfItems = Arrays.asList(items);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
    }

    @Override
    public List<Item> getItems() {
        return listOfItems;
    }

    @Override
    public List<Item> getItems(String category) {
        return listOfItems.stream().filter(item -> item.getCategory_short_name().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    @Override
    public List<Item> getItem(String itemShortName) {
        return listOfItems.stream().filter(item -> item.getShort_name().equalsIgnoreCase(itemShortName)).collect(Collectors.toList());
    }
}
