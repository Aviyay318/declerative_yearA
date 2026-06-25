import java.util.*;
import java.util.stream.Collectors;

public class Map_List_Declarative {
    public static void main(String[] args) {
        List<String> l1 = List.of("4","5","6","5");
        Map<Integer,String> myMap = new HashMap<>();
        myMap.put(8,"abcccc");
        myMap.put(2,"abc");

        //מחיקה עם דקלרטיבי
        //למחוק ערכים מרשימה
        //input - > ("4","5","6","5") , output -> ("4","6")
        List<String> result = l1.stream()
                .filter(s->!s.equals("5"))
                .toList();

        //במחיקה מרשימה אנחנו נשתמש
        // בפילטר ותמיד ניתן תנאי הפוך כדי שיכנסו כל מי
        // שעומד בתנאי שבדוגמא זה שונה מ5 כי רוצים למחוק את 5

        //פילטר עובדת - היא עוברת איבר איבר שואלת על תנאי בוליאני
        //מי שמקבל טרו נכנס לרשימה מי שמקבל פולס לא נכנס



        //דקלרטיבי על מפות
        //מעבר רק מפתחות - התנאים רק על המפתחות , וגם הערך החזרה שלי הוא רק מפתחות
        List<Integer> numbers = myMap.keySet()
                .stream()
                .filter(key-> key>3)
                .toList();

//מעבר רק על ערכים - תנאים רק על ערכים , והחזרה רק של ערכים

List<String> strings = myMap.values()
        .stream().filter(v->v.startsWith("hh"))
        .toList();


//מעבר על ערכים והחזרת מפתחות
        //תנאי על הערף ואני מחזירה מפתחות

        List<Integer> keyResult = myMap.entrySet()
                .stream()
                .filter(entry->entry.getValue().equals("jjk"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        //תמיד נשתמש בפונקציה map
        //כאשר אנחנו רוצים להחזיר סוג אחר של נתונים או שינוי של הנתונים

        //מחיקה ממפה
       myMap= myMap.entrySet()
                .stream()
                .filter(entry-> entry!=null && entry.getKey()<5)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        Set<Integer> keyResult2 = myMap.entrySet()
                .stream()
                .filter(entry->entry.getValue().equals("jjk"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());


//קיבוץ - מחזיר
        //<K, List<V>>
        //אנחנו רק אומרים לו לפי מה לקבץ

        List<Student> students = new ArrayList<>();

        Map<Integer,List<Student>> gropingByAge = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));

        Collections.sort(keyResult);

        Integer min = keyResult.stream()
                .min(Integer::compareTo)
                .get();

        List<String> names = new ArrayList<>();
        String shortedName = names.stream()
                .min(Comparator.comparing(String::length))
                .get();



       students = students.stream()
               .sorted(Comparator.comparing(Student::getName))
               .toList();

       //מציאת שם העיר עם הכי הרבה רחובות

    }
    public String cityWithMostStreets(List<Street> streets){
        Map<String,Long> countOfStreets =streets.stream()
           .collect(Collectors.groupingBy(Street::getCityName,Collectors.counting()));

        return countOfStreets.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String cityWithMostStreets2(List<Street> streets){
      return    streets.stream()
              //מקבץ לפי שם עיר (אבל עכשיו במקום לשים בערך רשימה של רחובות הוא שם את הכמות כמה יש רחובות לעיר)
                .collect(Collectors.groupingBy(Street::getCityName,Collectors.counting()))
                //עובדים על כל זוג במפה שחזרה המקיבוץ
                .entrySet()
                .stream()
              // אני רוצה למצוא את שם העיר שיש לה את הכמות רחובות המקסימלית - אז אני אומרת להשוואות לפי ערך
                .max(Map.Entry.comparingByValue())
              //בגלל שאני עובדת על איבר מסוג זוג של ערך ומפתח ומחזירה סוג ערך שונה אני מחזירה רק מפתח משתמשת במאפ כדי להחזיר מפתח
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<String> getCitiesByStreet(List<Street> streets, String streetName){
        return streets.stream()
                .filter(street -> street.getName().contains(streetName))
                .map(Street::getCityName)
                .distinct()
                .toList();
    }
}
