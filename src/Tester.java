public class Tester {

    public static void main(String[] args) {

        MeetingRoom meetingRoom = new MeetingRoom();

        for (int i = 1; i <= 10; i++) {
            new Thread(new Supplier(i, meetingRoom)).start();
            new Thread(new Consumer(i, meetingRoom)).start();
        }
    }

}
