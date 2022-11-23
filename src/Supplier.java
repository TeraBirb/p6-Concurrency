public class Supplier implements Runnable {

    private int data;
    private int ID;
    private MeetingRoom meetingRoom;

    public int getData() {
        return data;
    }

    public int getID() {
        return ID;
    }

    public Supplier(int ID, MeetingRoom meetingRoom) {

        this.ID = ID;
        this.data = (int)(1000 * Math.random());
        this.meetingRoom = meetingRoom;

    }

    @Override
    public void run() {

        while (true) {
            try {
                int sleepTime = (int) (1000 * Math.random());
//              System.out.println("Supplier #" + ID + " sleeps for " + sleepTime + " milliseconds.");
                Thread.sleep(sleepTime);
                meetingRoom.lock.lock();

                if (meetingRoom.getData() == -1) {

                    meetingRoom.setData(data);
                    meetingRoom.setDataID(ID);
                    System.out.println("-----> Supplier #" + ID + " || " + data + " dropped off " + data);

                } else {
//                    System.out.println("Supplier #" + ID + " || " + data +": Meeting room is not empty :(");
                }

                meetingRoom.lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
