package classTest;

public class classTest {
    public static void main(String[] args) {
        String day1 = "2021-09-11";
        String day2 = "2021-11-25";

        MyDate myDate = new MyDate();

        System.out.println(myDate.getNowDate());
        System.out.println(myDate.equals(day1));
        System.out.println(myDate.equals(day2));
        System.out.println(myDate.hashCode());
    }
}
