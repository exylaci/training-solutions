package week15.d02;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Curier {
    private LocalDateTime time;
    private String Id;
    private String address;


    public Curier(Curier curier) {
        this.time = curier.time;
    }

    public Curier(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate myDate = LocalDate.parse(date, format);
        this.time=LocalDateTime.of(myDate,LocalTime.of(0,0));
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getId() {
        return Id;
    }

    public String getAddress() {
        return address;
    }

    public void setTime(String time) {
        DateTimeFormatter format =  DateTimeFormatter.ofPattern("HH:mm");
        LocalTime myTime = LocalTime.parse(time,format);
        this.time = this.time.with(myTime);;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAddress(String[] address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length - 1; ++i) {
            s.append(address[i]);
        }
        this.address = s.toString();
    }

    @Override
    public String toString() {
        return "Curier{" +
                "time=" + time +
                ", Id='" + Id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
