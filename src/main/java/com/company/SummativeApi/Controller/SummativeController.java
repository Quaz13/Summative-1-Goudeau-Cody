package com.company.SummativeApi.Controller;

import com.company.SummativeApi.model.Summative;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class SummativeController {

    private List<Summative> summativeList;

    private static int idCounter =1;

    public SummativeController(){
        summativeList = new ArrayList<>();

        summativeList.add(new Summative( "Joseph Campbell", "All the gods, all the heavens, all the hells, are within you", idCounter++));
        summativeList.add(new Summative( "Woodrow Wilson", "This is the war to end all wars", idCounter++));
        summativeList.add(new Summative( "Earnest Hemingway", "Never think that war, no matter how necessary, nor how justified, is not a crime", idCounter++));
        summativeList.add(new Summative( "George Santana", "Only the dead have seen the end of war", idCounter++));
        summativeList.add(new Summative( "Henri Barbusse", "Two armies that fight each other is like one large army that commits suicide", idCounter++));
        summativeList.add(new Summative( "Frau Frieda Fischer of Lohndorf", "I like the American soldier individually but do not like the nation as a whole. America entered the war for what money she could get out of it", idCounter++));
        summativeList.add(new Summative( "William Westmoreland", "The military don't start wars. Politicians start wars", idCounter++));
        summativeList.add(new Summative( "Herbert Hoover", "Older men declare war. But it is the youth that must fight and die", idCounter++));
        summativeList.add(new Summative( "Norman Schwarzkopf", "The more you sweat in peace, the less you bleed in war", idCounter++));
        summativeList.add(new Summative( "Sun Tzu", "The supreme art of war is to subdue the enemy without fighting", idCounter++));
    }


    //POST
    @RequestMapping(value ="/quote", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Summative createSummative(@RequestBody @Valid Summative summative) {

        summative.setId(idCounter++);
        summativeList.add(summative);

        return summative;
    }

    //GET localhost:8080 /quote
    @RequestMapping(value ="/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Summative> getAllRecords(@RequestParam(required = false) String author, @RequestParam(required = false) String quote) {

        List<Summative> returnList = new ArrayList<>();
        Random randomMethod = new Random();

        if(author != null) {
            for (Summative summative : summativeList) {
                if (summative.getAuthor().contains(author)) {
                    returnList.add(summative);
                }
            }
        }   else if (quote != null) {
                for (Summative summative : summativeList) {
                    if (summative.getAuthor().contains(author)) {
                        returnList.add(summative);
                    }
                }
        }   else {
            returnList = summativeList;
        }

        return returnList;
    }

    //GET /quotes/{id}
    @RequestMapping(value ="/quote/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Summative getSummativeById(@PathVariable int id) {

        Summative foundSummative = null;

        for (Summative summative : summativeList) {
            if (summative.getId() == id) {
                foundSummative = summative;
                break;
            }
        }

        return foundSummative;
    }

    //PUT /records/{id}
    @RequestMapping(value ="/quote", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateRecordById(@PathVariable int id, @RequestBody Summative summative) {

        int index = -1;
        for (int i=0; i < summativeList.size(); i++) {
            if (summativeList.get(i).getId() == id) {
                index = i;
                break;
            }

            if(index >=0 ) {
                summativeList.set(index,summative);
            }
        }
    }

    @RequestMapping(value = "/quote/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRecordById(@PathVariable int id) {
        int index = -1;

        for(int i = 0; i < summativeList.size(); i++) {
            if(summativeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            summativeList.remove(index);
        }
    }


}
