package com.company.SummativeApi.Controller;

import com.company.SummativeApi.model.Words;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SummativeWordsController {
    private List<Words> wordList;

    private static int idCounter =1;

    public SummativeWordsController() {
        wordList = new ArrayList<>();

        wordList.add(new Words( "Thumb", "the short, thick first digit of the human hand, set lower and apart from the other four and opposable to them", idCounter++));
        wordList.add(new Words( "Tremendously", "very great in amount, scale, or intensity", idCounter++));
        wordList.add(new Words( "Forehead", "the part of the face above the eyebrows", idCounter++));
        wordList.add(new Words( "Fracture", "the cracking or breaking of a hard object or material", idCounter++));
        wordList.add(new Words( "Unknown", "not known or familiar", idCounter++));
        wordList.add(new Words( "Codex", "an ancient manuscript text in book form", idCounter++));
        wordList.add(new Words( "Flabbergasted", "feeling or showing intense shock, surprise, or wonder", idCounter++));
        wordList.add(new Words( "Cannibal", "a person who eats the flesh of other human beings", idCounter++));
        wordList.add(new Words( "Traverse", "travel across or through", idCounter++));
        wordList.add(new Words( "Dimension", " the different facets of what we perceive to be reality", idCounter++));

    }

    //Get localhost:8080
    @RequestMapping(value ="/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Words> getAllWords(@RequestParam(required = false) String word, @RequestParam(required = false) String definition) {

        List<Words> returnList = new ArrayList<>();

        if (word != null) {
            for (Words words : wordList) {
                if (words.getWord().contains(word)) {
                    returnList.add(words);
                }
            }
        } else if (definition != null) {
            for (Words words : wordList) {
                if (words.getWord().contains(word)) {
                    returnList.add(words);
                }
            }
        } else {
            returnList = wordList;
        }

        return returnList;
    }


}

