import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                .toList();

        //תמיד נשתמש בפונקציה map
        //כאשר אנחנו רוצים להחזיר סוג אחר של נתונים או שינוי של הנתונים

        //מחיקה ממפה
       // Map<Integer,String> resultMap = myMap.entrySet()


    }
}
