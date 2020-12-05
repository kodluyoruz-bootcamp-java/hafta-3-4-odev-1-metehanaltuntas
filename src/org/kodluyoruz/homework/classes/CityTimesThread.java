package org.kodluyoruz.homework.classes;

public class CityTimesThread implements Runnable{

    private City city;

    public CityTimesThread(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public void run() {
        city.showTime();
    }
}
