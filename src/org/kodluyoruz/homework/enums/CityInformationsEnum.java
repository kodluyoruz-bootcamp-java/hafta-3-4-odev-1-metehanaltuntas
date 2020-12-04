package org.kodluyoruz.homework.enums;

public enum CityInformationsEnum {
    MOSCOW("MOW","Moscow","GMT+3:00"),
    NEW_YORK("NYC","New York","GMT-5:00"),
    LONDON("LON","London","GMT+0:00"),
    BERLIN("BER","Berlin","GMT+1:00"),
    NEW_DELHI("DEL","New Delhi","GMT+5:30");

    private final String code;
    private final String name;
    private final String gmt;

    CityInformationsEnum(String code, String name, String gmt) {
        this.code = code;
        this.name = name;
        this.gmt = gmt;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getGmt() {
        return gmt;
    }

}
