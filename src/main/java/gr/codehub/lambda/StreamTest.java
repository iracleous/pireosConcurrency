package gr.codehub.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {


        List<String> strings = new ArrayList<>();
        strings.add("dimitris");
        strings.add("giannisffff");
        strings.add("giannis 2dd");
        strings.add("giannis 3w");
        strings.add("giannis 2w");

//        for (int i = 0; i<strings.size(); i++){
//            System.out.println(strings.get(i));
//        }
//
//        for (String string : strings){
//            System.out.println(string);
//        }


   //     strings.forEach( string -> System.out.println(string));

    //    Stream<String> stream = strings.stream();

       //find the size of a list after filtering
        long countGiannisItems = strings
                .stream()
                .map(item  -> item.toUpperCase())
                .filter(item -> item.contains("GIANNIS"))
                .count();

        //find the size of the longest word
        int longestSize = strings
                .stream()
                .map(item  -> item.length())
                .max(Comparator.comparing(Integer::valueOf))
                .orElseThrow(NoSuchElementException::new);


        Optional<Integer>  optMinSize =strings
                .stream()
                .map(item  -> item.length())
                .max(Comparator.comparing(Integer::valueOf));


        if(optMinSize.isPresent()) {
            System.out.println("minSize = " + optMinSize.get());
        }

       int optMinSize2 =strings
                .stream()
                .map(p->p.length())
                .limit(2)
                .reduce(Math::min)
               .orElseThrow(NoSuchElementException::new);

        int i=0;

        String s1= i+"";
        String s2= Integer.toString(i);

        System.out.println(longestSize);



        /////////////////////////////////////////////////
        // resulting a new List
        List<String> upperCaseList = strings.stream()
                .map(item -> item.toUpperCase())
                .collect( Collectors.toList());

        System.out.println(upperCaseList);

        // to get the third item
        String name = strings.stream()
                .skip(2)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        // to get the name =giannisffff
        String specificItem = strings.stream()
                .filter(item -> item.equalsIgnoreCase("Giannisffff"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);


        //sorting

        List<String> sortedList =  strings.stream()
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect( Collectors.toList());

        System.out.println("Sorting reversely");
        System.out.println(sortedList);


    }
}
