package week15.d02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Order {
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private LocalDate date;
    private LocalTime time;
    private String courier;
    private String address;


    public Order(LocalDate date) {
        this.date = date;
    }

    public Order(String date) {
        this.date = LocalDate.parse(date, dateFormat);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCourier() {
        return courier;
    }

    public String getAddress() {
        return address;
    }

    public void setTime(String time) {
        this.time = LocalTime.parse(time, timeFormat);
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public void setAddress(String[] address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length - 1; ++i) {
            sb.append(address[i]).append(" ");
        }
        this.address = sb.toString().trim();
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date + " " + time +
                " courier=" + courier +
                " address=" + address + "}\n";
    }
}
