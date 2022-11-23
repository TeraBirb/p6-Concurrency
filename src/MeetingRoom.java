import java.util.concurrent.locks.*;

public class MeetingRoom {

    private int data = -1;
    private int dataID = -1;
    public Lock lock = new ReentrantLock();

    public int getData() {
        return data;
    }

    public int getDataID() {
        return dataID;
    }

    public void setData(int data) {
        lock.lock();
        this.data = data;
        lock.unlock();
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public void reset() {
        this.data = -1;
        this.dataID = -1;
    }

}
