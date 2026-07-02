public class Account {
    private int balance;
    private int addAbc;
    private int add_abc;
    private int [] arr;

    public void deposit(){
        synchronized (this){
            this.balance ++;

        }
        System.out.println("n");
    }

    public synchronized void withdraw(){
        this.balance--;
    }

}
