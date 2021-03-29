package com.epam.jwd.parser;

import java.util.stream.Stream;

public class CustomArrayStringParser {

    public int[] parse(String input){
        return Stream
                .of(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
