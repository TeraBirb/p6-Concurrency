public class Consumer implements Runnable {

    private int data;
    private int ID;
    private MeetingRoom meetingRoom;

    public int getData() {
        return data;
    }

    public int getID() {
        return ID;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Consumer(int ID, MeetingRoom meetingRoom) {
        this.ID = ID;
        this.meetingRoom = meetingRoom;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int sleepTime = (int) (1000 * Math.random());
//              System.out.println("Consumer #" + ID + " sleeps for " + sleepTime + " milliseconds.");
                Thread.sleep(sleepTime);

                if (meetingRoom.getDataID() != ID) {
                    System.out.println("Consumer #" + ID + ": Either there's no data or the data is for a different ID!");
                } else {
                    meetingRoom.lock.lock();
                    System.out.println("----> Consumer #" + ID + " has successfully retrieved " + meetingRoom.getData() +
                            "!");
                    setData(meetingRoom.getData());
                    meetingRoom.reset();
                    meetingRoom.lock.unlock();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
