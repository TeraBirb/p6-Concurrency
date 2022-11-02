import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MeetingRoom implements Runnable {

    private ArrayList<Supplier> suppliers = new ArrayList<>();
    private ArrayList<Supplier> consumers = new ArrayList<>();
    public Lock lock = new ReentrantLock();


    // runnable and run method
    // create 10 threads each for consumer and supplier
    // create Lock
    // create data container that will receive dropped off data & data ID
    // while true
    // threads check if data container is empty or not for them and exits

    // maybe consumers and suppliers are runnable? watch java video first.
    public void run() {

        System.out.println("start of run");

        for (int i = 1; i <= 10; i++) {
            suppliers.add(new Supplier(i));
            consumers.add(new Supplier(i));
        }

        for (Supplier supplier : suppliers) {
            try {
                Thread.sleep((int) (1000 * Math.random()));
                System.out.println(supplier.getID() + " " + supplier.getData());
            }
            catch(Exception e) {}
        }

        System.out.println("end of run");

    }


}
