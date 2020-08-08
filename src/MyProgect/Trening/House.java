package MyProgect.Trening;
public class House {
    private static String color;
    private static int roomCount;

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        House.color = color;
    }

    public static int getRoomCount() {
        return roomCount;
    }

    public static void setRoomCount(int roomCount) {
        House.roomCount = roomCount;
    }

    public static void getColor(String green) {
    }

    public void doorOpen(boolean keysOpen){

    }
    public void doorCloss(boolean kesCloss){


    }

    public static void main(String[] args) {
        System.out.println(getRoomCount());
        System.out.println(getColor());
    }


}
