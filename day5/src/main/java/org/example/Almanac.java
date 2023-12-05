package org.example;

import java.util.Scanner;

import static org.example.Iden.*;

public class Almanac {
    private final Dictionary seedSoil;
    private final Dictionary soilFertilizer;
    private final Dictionary fertilizerWater;
    private final Dictionary waterLight;
    private final Dictionary lightTemperature;
    private final Dictionary temperatureHumidity;
    private final Dictionary humidityLocation;
    private final Dictionary[] ds;
    public Almanac (Scanner sc){
        seedSoil = new Dictionary(SEED,SOIL);
        soilFertilizer = new Dictionary(SOIL, FERTILIZER);
        fertilizerWater = new Dictionary(FERTILIZER,WATER);
        waterLight = new Dictionary(WATER,LIGHT);
        lightTemperature = new Dictionary(LIGHT,TEMPERATURE);
        temperatureHumidity = new Dictionary(TEMPERATURE,HUMIDITY);
        humidityLocation = new Dictionary(HUMIDITY,LOCATION);
        ds = new Dictionary[]{seedSoil,soilFertilizer,fertilizerWater,waterLight,lightTemperature,temperatureHumidity,humidityLocation};
        for (Dictionary d: ds) {
            System.out.println(d.names());
            while (!sc.hasNextDouble()){sc.next();}
            do {
                double k2 = sc.nextDouble();
                double k1 = sc.nextDouble();
                double l = sc.nextDouble();
                d.link(k1,k2,l);


            } while (sc.hasNextDouble());

        }


    }
    public double get(Iden start, Iden end, double v){
        return getR(start,findDict(start).name(1),v,end);
    }
    public double getR(Iden start, Iden end, double v, Iden tEnd){
        if (!(end == tEnd)){
            //System.out.printf("%s %f : %s %f\n",start.name(),v,end.name(),findDict(start).get(v,1));
            return getR(end,findDict(end).name(1),findDict(start).get(v,1),tEnd);
        }
        return findDict(start).get(v,1);
    }
    private Dictionary findDict(Iden i){
        for (Dictionary d: ds){
            if (d.name(0) == i){return d;}}
        return null;
    }

}
