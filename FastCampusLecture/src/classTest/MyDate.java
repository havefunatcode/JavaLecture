package classTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MyDate {
    private String nowDate;

    public MyDate() {
        LocalDate now = LocalDate.now();
        this.nowDate = now.toString();
    }

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "nowDate='" + nowDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this.nowDate.equals(o)) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nowDate);
    }
}
