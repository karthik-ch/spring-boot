package com.streamlinity.ct.springRestChallenge.solution;

import com.streamlinity.ct.springRestChallenge.api.SearchSvcInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/*
 * This controller needs to expose the following rest endpoints.  You need to fill in the implementation here
 *
 * Required REST Endpoints
 *
 *      /item                       Get all items
 *      /item?category=C            Get all items in category specified by Category shortName
 *      /item/{itemShortName}       Get item that matches the specified Item shortName
 */

@Profile("default")
@RestController
public class SearchRestControllerImpl {

    @Autowired
    private SearchSvcInterface searchService;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ResponseEntity<?> getItemByCategory(@RequestParam(required = false) String category) {
        if(category==null || category.isEmpty()) {
            return new ResponseEntity<>(searchService.getItems(), HttpStatus.OK);
        }
        return new ResponseEntity<>(searchService.getItems(category), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/{shortName}", method = RequestMethod.GET)
    public ResponseEntity<?> getItemByShortName(@PathVariable String shortName) {
            return new ResponseEntity<>(searchService.getItem(shortName), HttpStatus.OK);
         }

}
