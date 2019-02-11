package com.company;

import java.util.*;
/*Rylee Charlton, 2/7/19, Exercise 4*/


public class Main {
    static void displayCities(Map<String, List<Double> >cities) {
        for (String key: cities.keySet()) {
            List<Double> temps = cities.get(key);
            Double total = 0.0;
            for(int j = 0; j < temps.size(); j++){
                total = total + temps.get(j);
            }
            total = total/temps.size();
            System.out.println("City: " + key
                    + " " + "Average: " + total);
        }
    }

    static Map<String, List<Double>> assignTemperatures(List <String> cityNames,
                                                        List<Double> temps) {
        Map<String,List<Double>> temperatures = new TreeMap<>();


        for (int i = 0; i < cityNames.size(); i++) {
            List<Double> t = new ArrayList<>();
            for (int j = i * 5; j < ((i * 5) + 5); j++){
                t.add(temps.get(j));
            }
            temperatures.put(cityNames.get(i), t);
        }
        return temperatures;
    }


    public static void main(String[] args) {
        Double averageCity;
        Scanner avg = new Scanner(System.in);
        String cityInput = "";
        Scanner input = new Scanner(System.in);

        List<String> cityNames = new ArrayList<>();
        List<Double> temps = new ArrayList<>();

        while (!(cityInput.toUpperCase().equals("END"))) {

            System.out.println("Please enter a City. Enter 'END' to quit.");
            cityInput = input.nextLine();
            if (cityInput.toUpperCase().equals("END")) {
                break;
            }

            cityNames.add(cityInput);
        }

        for(int j = 0; j < cityNames.size(); j++) {


            for (int i = 0; i < 5; i++) {
                System.out.println("Please enter a temperature.");
                Double temp = avg.nextDouble();
                temps.add(temp);
            }
        }

        Map<String, List<Double>> temperatures = assignTemperatures(cityNames, temps);

        displayCities(temperatures);
    }
}