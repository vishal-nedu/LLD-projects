package Playground.SD.railwayticket;

public class Passenger
{
    String ticketId;
    String name;
    int age;
    char gender;
    String berth;

    public Passenger(String ticketId, String name, int age, char gender, String berth) {
        this.ticketId = ticketId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berth = berth;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ticketId='" + ticketId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", berth='" + berth + '\'' +
                '}';
    }
}
