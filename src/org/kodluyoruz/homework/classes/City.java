package org.kodluyoruz.homework.classes;

import org.kodluyoruz.homework.interfaces.IClock;
import org.kodluyoruz.homework.enums.CityInformationsEnum;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class City implements IClock, Comparable<City> {

    private String code;
    private String name;
    private String gmt;

    public City(CityInformationsEnum cityInformationsEnum) {
        this.code = cityInformationsEnum.getCode();
        this.name = cityInformationsEnum.getName();
        this.gmt = cityInformationsEnum.getGmt();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    @Override
    public void showTime() {
        boolean flag = true;
        String timeString = "";
        while (flag) {
            ThreadSleeper.sleep(1000);
            TimeZone.setDefault(TimeZone.getTimeZone(this.gmt));
            ZoneId zoneId = ZoneId.systemDefault();
            LocalTime time = LocalTime.now(zoneId);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            timeString = time.format(dateTimeFormatter);
            System.out.printf("%s | %s | %-10S | %-10s | %s \n", Thread.currentThread().getName(), this.code, this.name, this.gmt, timeString);

            // tek sefer göstermek için
            //flag = false;
        }
    }

    // şehirlerin isimlerine göre sıralanması
    @Override
    public int compareTo(City o) {
        return this.getName().compareTo(o.getName());
    }

    // listeye aynı şehrin birden fazla kez eklenmemesi için
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(code, city.code) && Objects.equals(name, city.name) && Objects.equals(gmt, city.gmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, gmt);
    }

}
