package com.goldmann;

import java.util.Arrays;

import static java.lang.Math.round;

public class Main {
    // <rok0> <mesic1> <den2> <prum.tep.|C3> <max.tep.|C4> <min.tep.|C5> <tlak|hPa6> <rychl.vetru|m/s7> <vlhkost|%8> <srazky|mm>
    private static final String[] DATA = new String[]{
            "2019 7 1 24.2 35.4 18.9 986.5 2.0 64 18.9",
            "2019 7 2 22.3 27.1 17.4 988.2 3.1 60 0.0",
            "2019 7 3 19.8 23.9 14.9 991.6 3.7 45 0.0",
            "2019 7 4 19.9 25.6 12.5 991.7 2.2 46 0.0",
            "2019 7 5 20.9 26.5 12.0 985.9 2.9 47 0.0",
            "2019 7 6 24.7 32.8 11.3 980.5 2.3 41 0.0",
            "2019 7 7 20.3 26.0 16.1 980.1 2.8 49 0.7",
            "2019 7 8 17.4 21.9 12.0 986.1 3.8 45 0.0",
            "2019 7 9 17.2 21.9 12.7 986.9 4.0 46 0.0",
            "2019 7 10 17.8 21.4 12.6 987.0 3.1 48 0.0",
            "2019 7 11 19.6 25.7 8.7 984.1 3.7 45 0.3",
            "2019 7 12 16.4 20.0 13.4 983.1 2.0 87 13.1",
            "2019 7 13 16.1 20.0 12.8 982.2 2.2 91 8.5",
            "2019 7 14 18.8 23.3 14.7 984.6 4.3 62 0.0",
            "2019 7 15 16.9 22.8 12.6 985.7 3.2 74 5.8",
            "2019 7 16 18.4 23.5 12.3 985.3 3.7 60 0.0",
            "2019 7 17 19.5 24.6 10.8 984.3 3.3 56 0.0",
            "2019 7 18 21.1 26.6 13.4 984.2 1.9 52 0.0",
            "2019 7 19 20.9 28.2 13.6 986.8 2.3 66 0.8",
            "2019 7 20 24.8 30.9 16.1 987.2 2.5 55 0.0",
            "2019 7 21 22.0 29.1 18.1 990.9 2.3 71 1.3",
            "2019 7 22 22.3 29.6 16.0 993.4 2.0 63 0.0",
            "2019 7 23 25.3 31.3 19.9 991.0 4.8 51 0.0",
            "2019 7 24 26.3 33.0 16.6 989.3 3.1 53 0.0",
            "2019 7 25 27.6 34.3 17.8 988.3 1.9 46 0.0",
            "2019 7 26 27.6 34.3 18.3 981.0 3.5 43 0.4",
            "2019 7 27 20.0 27.3 19.0 976.8 4.4 81 1.9",
            "2019 7 28 22.5 29.1 17.6 973.8 4.0 74 2.5",
            "2019 7 29 24.0 31.2 18.6 978.3 2.4 71 0.0",
            "2019 7 30 22.9 29.0 18.4 982.1 1.8 77 3.9",
            "2019 7 31 22.7 29.0 19.6 984.9 1.8 77 2.6",
    };

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Welcome to the application for Meteorological Data Analysis.");
        System.out.println("We have " + DATA.length + " meteorological daily records to analyze.");


        double suma = 0;
        double maxTemp = 0;
        int maxTempLine = 0;
        double minTemp = 100;
        int minTempLine = 0;
        int numWindyDay = 0;
        int numCalmDay = 0;
        float sumSrazek10 = 0;
        double sumSrazek20 = 0;
        double sumSrazek30 = 0;


        for (int i = 0; i < DATA.length; i++) {
            suma += Double.parseDouble(DATA[i].split(" ")[3]);
            if ((Double.parseDouble(DATA[i].split(" ")[4]) > maxTemp)) {
                maxTemp = Double.parseDouble(DATA[i].split(" ")[4]);
                maxTempLine = i;
            }
            if ((Double.parseDouble(DATA[i].split(" ")[5]) < minTemp)) {
                minTemp = Double.parseDouble(DATA[i].split(" ")[5]);
                minTempLine = i;
            }
            if ((Double.parseDouble(DATA[i].split(" ")[7]) >= 4.2)) {
                numWindyDay++;
            }
            if ((Double.parseDouble(DATA[i].split(" ")[7]) <= 1.8)) {
                numCalmDay++;
            }
            if ((Double.parseDouble(DATA[i].split(" ")[2]) <= 10)) {
                sumSrazek10 += Double.parseDouble(DATA[i].split(" ")[9]);
                System.out.println(sumSrazek10);
            } else if ((Double.parseDouble(DATA[i].split(" ")[2]) <= 20)) {
                sumSrazek20 += Double.parseDouble(DATA[i].split(" ")[9]);
            } else {
                sumSrazek30 += Double.parseDouble(DATA[i].split(" ")[9]);
            }


        }


        System.out.println("Average temperature for the reporting period: " + round(suma / DATA.length * 100) / 100.00 + "°C");

        String[] maxLine = DATA[maxTempLine].split(" ");
        System.out.println("Maximum temperature for the reporting period: " + maxLine[0] + "-" + maxLine[1] + "-" + maxLine[2] + " was " + maxLine[4]);

        String[] minLine = DATA[minTempLine].split(" ");
        System.out.println("Minimum temperature for the reporting period: " + minLine[0] + "-" + minLine[1] + "-" + minLine[2] + " was " + minLine[5]);

        System.out.println("Number of windy days: " + numWindyDay);

        System.out.println("Number of calm days: " + numCalmDay);

        System.out.println("Precipitation summary in month decades: " + sumSrazek10 + "mm - " + sumSrazek20 + "mm - " + + sumSrazek30 + "mm");
    }

}



