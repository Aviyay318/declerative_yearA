import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyList {
    public static void main(String[] args) {

        List<String> l1 = List.of("4","5","6");

        List<String> myList = new ArrayList<>();
        //הוספה
        myList.add("2");
        myList.addAll(l1);
        myList.add(2,"88");

        //מחיקה
        myList.remove("4"); //false
        //לבדוק שאינדקס לא גדול מגודל הרשימה
        myList.remove(4); //error
        myList.removeAll(l1);
        myList.clear(); //מרוקנת לגמרי את הרשימה

        //גישה לאיבר
        myList.get(1);
        myList.set(2,"99"); //עדכון לערך חדש


        //
        myList.isEmpty();
        //בדיקה אם איבר קיים
        myList.contains("2");
        myList.size();

        //מיקום של איבר ספציפי
        int index = myList.indexOf("2");//המיקום של האיבר הזה הראשון
        myList.lastIndexOf("2"); //המיקום של האיבר הזה האחרון

        //מיון
        Collections.sort(myList);


        //לעבור על רשימה
        // for (TYPE name: the myList)
        for (String s:myList){
            System.out.println(s);
        }
        /// אי אפשר לגשת לאינדקס
        /// אי אפשר למחוק
        //forEach

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals("2")){
                myList.remove(i);
                i--;
            }
        }
        for (int i = myList.size()-1; i >=0 ; i--) {
            if (myList.get(i).equals("2")){
                myList.remove(i);
            }
        }
        //לא חובה למבחן
        //להסיר עם איטרטור
        Iterator<String> it = myList.iterator();

        while (it.hasNext()){
            String item = it.next();
            if (item.equals("2")){
                it.remove();
            }
        }

        myList.forEach(System.out::println);

    }


}
