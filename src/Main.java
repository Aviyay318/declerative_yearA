import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {













        Map<String,Student> studentMap = new HashMap<>();

       studentMap.get("1111111");



    }

    public static List<String> f1( List<Street> streets){
        return streets.stream()
                .filter(street -> street.getName().startsWith("A"))
                .map(street -> street.getCity().getName())
                .toList();
    }


    public static List<String> f2( List<Street> streets){
        return streets.stream().filter(Street::isStartWithA) //street -> street.isStartWithA()
                .map(street -> street.getCity().getName())
                .toList();
    }

    //
public static Map<String,List<Street>> streetByCity(List<Street> streets){
      return streets.stream()
              .collect(Collectors.groupingBy(street -> street.getCity().getName()));
}

    public static Map<String,List<Street>> streetByCity2(List<Street> streets){
        return streets.stream()
                .collect(Collectors.groupingBy(Street::getCityName));
    }

    //כתבו פונקציה שמקבלת רשימה של רחובות , ושם רחוב נוסף ומחזירה את כמות הרחובות ששוות לה
    public static long countOfStreet(List<Street> streets , String newStreet){

        return streets.stream()
                .filter(street -> street.getName().equals(newStreet))
                .count();

    }


}