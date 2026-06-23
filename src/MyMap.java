import java.util.*;

public class MyMap {

    public static void main(String[] args) {
        Map<Integer,String> myMap = new HashMap<>();
        Map<Integer,String> myMap1 = new TreeMap<>() ;//ממיינת את המפתחות
        Map<Integer,String> myMap2 = new LinkedHashMap<>();//שומרת על סדר ההכנסה

        //Map<key,value>
        //מפתח ייחודי תמיד בכל המפות
     //   Map<String, List<Integer>> myMap2 = new HashMap<>();

        Map<City,String> cityStringMap = new HashMap<>();
        City c1 = new City("ash");
        City c2 = new City("tytyt");
        cityStringMap.put(c2,"c2");
        cityStringMap.put(c1,"c1");

       // System.out.println(cityStringMap);

        //הוספה
        myMap.put(8,"abcccc");
        myMap.put(2,"abc");

      //  System.out.println(myMap);

        myMap1.put(3,"hhh");
        myMap1.put(2,"hhh");
        myMap1.put(4,"htttthh");

        myMap.putAll(myMap1);



        //הוספה רק אם המפתח לא קיים כבר ברשימה אם קיים לא מוסיפים
        myMap.putIfAbsent(2,"uuuu");
        myMap.putIfAbsent(12,"uuuu");

        System.out.println(myMap);


        //גישה לאיבר
        //לפי מפתח KEY
        //אנחנו נעביר את המפתח ונקבל את הערך
        String value = myMap.get(12);//אם לא קיים חוזר NULL
        System.out.println(value);

        //מחיקה
        //מחיקה לפי מפתח - אנחנו שולחים מפתח אם קיים במפה האיבר מוסר - הערך והמפתח
        myMap.remove(12);
        myMap.clear();// מרוקן את המפה

        //פונקציות כלליות
        //אני רוצה לדעת אם קיים מפתח כל שהוא
       boolean isExist =  myMap.containsKey(2);
       myMap.containsValue("uuuu");//האם קיים ערך מסויים

        myMap.isEmpty();
        myMap.size();

        //מעבר על מפה
        //מעבר רק על המפתחות
        for (Integer k: myMap.keySet()){
            System.out.println(k);
        }

        //מעבר רק על הערכים
        for (String v:myMap.values()){
            System.out.println(v);
        }

        //מעבר על הזוגות
        for (Map.Entry<Integer,String> entry: myMap.entrySet()){
            System.out.println(entry); //(2="uuu")
            System.out.println("key : " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }
    }
}
