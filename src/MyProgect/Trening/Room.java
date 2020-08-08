package MyProgect.Trening;



public class Room {

    public static void main(String[] args) {
        House house = new House();
        House.setRoomCount(20);
        House.setColor("blue");
        System.out.println("args = " + House.getRoomCount());
        System.out.printf("");
        System.out.println("House - " + House.getColor());
    }
}
