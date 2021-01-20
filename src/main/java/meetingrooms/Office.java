package meetingrooms;

import meetingrooms.MeetingRoom;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; --i) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 0; i < meetingRooms.size(); ++i) {
            if (i % 2 != 0) {
                System.out.println(meetingRooms.get(i).getName());
            }
        }
    }

    public void printAreas() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            printOneMeetingRoom(meetingRoom);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().equals(name)) {
                printOneMeetingRoom(meetingRoom);
            }
        }
    }

    public void printMeetingRoomsContains(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().contains(name.toLowerCase())) {
                printOneMeetingRoom(meetingRoom);
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                printOneMeetingRoom(meetingRoom);
            }
        }
    }

    private void printOneMeetingRoom(MeetingRoom meetingRoom) {
        System.out.println(meetingRoom.getName() + ": " +
                " szélte: " + meetingRoom.getWidth() +
                " hossza: " + meetingRoom.getLength() +
                " területe: " + meetingRoom.getArea());
    }
}
