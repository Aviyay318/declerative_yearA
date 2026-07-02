import java.util.ArrayList;
import java.util.List;

public class MyThread {
    private final Object lock;
    private   List<Integer> list = new ArrayList<>();

    public MyThread(){
        this.lock = new Object();
    }




    //סנכרון עם
    //Object
    private void my_thread(){
        new Thread(()->{
            while (true){

                synchronized (lock){
                    System.out.println("X");
                }

            }
        }).start();

    }

    public static void main(String[] args) {

       //מזה מנעול בג'אווה?
        //כל אובייקט הוא מנעול!!!!
        //1) Object
        //2) this - האובייקט הנוכחי
        //3) list
        //4) Map
        //5)אובייקט שהוא המשאב המשותף

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                while (true){

                    synchronized (list){
                        while (list.isEmpty()){
                            try {
                                list.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

//wait and notify
//חייבים לעבוד בתוך סינכרונייז ועל המנעול (שאותו בחרתם לשים בתוך הסינכורייז)
 //משחרר את המנעול וכן נותן גישה למשאב המשותף בזמן ההמתנה
 //נרצה לעשות
 //wait
//נעשה אותו בתוך לולאה עם תנאי
 //כאשר עשיתם וויט - המתנה חייבבבבבבבבבבב לדאוג למקום להעירררר
 //לעשות notify
 //the wait is wait for notify


















                        







                        //-----------------
                        if (list.isEmpty()){
                            try {
                                list.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        list.remove(0);
                    }

                }
            }).start();
        }


    }

//sleep - לא משחרר את המנעול
    //לא נרצה לשים אותו בתוך הסינכונייז
    //במקרים שאנחנו רוצים לחסוך פעולת מעבד - מבזבזים , שזה קשור בזמן ידוע

public void add(int x){
    synchronized (this){
        this.list.add(x);
        this.notify();
    }
}




}
