import java.util.*;

public class Supplier {

    private int data;
    private int ID;

    public int getData() {
        return data;
    }

    public int getID() {
        return ID;
    }

    public Supplier(int ID) {

        this.ID = ID;
        this.data = (int)(1000 * Math.random());

    }

}
