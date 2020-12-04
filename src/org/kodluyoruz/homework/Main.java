package org.kodluyoruz.homework;

import org.kodluyoruz.homework.classes.*;
import org.kodluyoruz.homework.enums.CityInformationsEnum;

import java.util.*;

public class Main {

    private static List<City> cityList;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    void start() {
        CityInformationsEnum moscowEnum = CityInformationsEnum.MOSCOW;
        CityInformationsEnum newYorkEnum = CityInformationsEnum.NEW_YORK;
        CityInformationsEnum londonEnum = CityInformationsEnum.LONDON;
        CityInformationsEnum berlinEnum = CityInformationsEnum.BERLIN;
        CityInformationsEnum newDelhiEnum = CityInformationsEnum.NEW_DELHI;

        City moscowCity = new MoscowCity(moscowEnum);
        City newYorkCity = new NewYorkCity(newYorkEnum);
        City londonCity = new LondonCity(londonEnum);
        City berlinCity = new BerlinCity(berlinEnum);
        City newDelhiCity = new NewDelhiCity(newDelhiEnum);

        Map<String, City> cityMap = new HashMap<>();
        cityMap.put(moscowCity.getCode(), moscowCity);
        cityMap.put(newYorkCity.getCode(), newYorkCity);
        cityMap.put(londonCity.getCode(), londonCity);
        cityMap.put(berlinCity.getCode(), berlinCity);
        cityMap.put(newDelhiCity.getCode(), newDelhiCity);

        // City list' ini sort metoduna gönderdiğimizde City sınıfındaki compareTo() metoduna göre sıralama yapacak
        cityList = new ArrayList<>(cityMap.values());
        Collections.sort(cityList);

        Scanner scanner = new Scanner(System.in);
        String chosenCityCode;

        boolean keepContinue = true;
        while (keepContinue) {
            Set<String> chosenCityCodes = new HashSet<>();
            boolean flag = true;
            System.out.println("Saatini öğrenebileceğiniz şehirlerin listesi aşağıdadır:");
            for (City line : cityList) {
                System.out.println("\t - Kod: " + line.getCode() + " | " + "Şehir adı: " + line.getName());
            }
            while (flag) {
                if (chosenCityCodes.size() == 5) {
                    flag = false;
                    keepContinue = false;
                    showTime(findCitiesInformations(chosenCityCodes));
                } else {
                    System.out.println("Lütfen en az 3 en fazla 5 tane şehir seçiniz. Seçim işleminiz bittikten sonra OK yazarak" +
                            " işlemi tamamlayabilirsiniz. [Bir şehir birden fazla kez seçilemez]");
                    System.out.println("Şu an " + chosenCityCodes.size() + " adet şehir seçtiniz. " + (5 - chosenCityCodes.size()) + " adet daha şehir seçebilirsiniz.");
                    printChosenCityCodes(chosenCityCodes);
                    chosenCityCode = scanner.nextLine().toUpperCase();
                    boolean isCodeCorrect = isCityCodeCorrect(chosenCityCode);
                    if (chosenCityCode.equals("OK") && chosenCityCodes.size() >= 3) {
                        // listeyi gönder
                        flag = false;
                        keepContinue = false;
                        showTime(findCitiesInformations(chosenCityCodes));
                    } else if (chosenCityCode.equals("OK") && chosenCityCodes.size() < 3) {
                        System.out.println("Üzgünüm, henüz yeteri kadar şehir eklemediniz.");
                    } else {
                        if (isCodeCorrect) {
                            chosenCityCodes.add(chosenCityCode);
                        } else {
                            System.out.println("Böyle bir işlem yok. Lütfen doğru kodlar kullanın!");
                        }
                    }
                }
            }
        }
    }

    void printChosenCityCodes(Set<String> chosenCityCodes) {
        String cityCodes = "";
        for (String chosenCityCode: chosenCityCodes) {
            cityCodes = cityCodes + " " + chosenCityCode;
        }
        if (cityCodes.equals("")){
            System.out.println("Seçilen şehir kodları: Henüz bir şehir eklemediniz.");
        }else {
            System.out.println("Seçilen şehir kodları: " + "[" + cityCodes + " ]");
        }
    }

    boolean isCityCodeCorrect(String cityCode) {
        boolean isCodeCorrect = false;
        for (City city : cityList) {
            if (cityCode.equals(city.getCode())) {
                isCodeCorrect = true;
                break;
            }
        }
        return isCodeCorrect;
    }

    List<City> findCitiesInformations(Set<String> chosenCityCodes) {

        List<City> chosenCitiesInformations = new ArrayList<>();

        for (String chosenCityCode : chosenCityCodes) {
            for (int i = 0; i < cityList.size(); i++) {
                String code = cityList.get(i).getCode();
                if (code.equals(chosenCityCode)) {
                    chosenCitiesInformations.add(cityList.get(i));
                }
            }
        }
        return chosenCitiesInformations;
    }

    void showTime(List<City> chosenCityList) {
        for (City city : chosenCityList) {
            city.showTime(city);
        }
    }
}
