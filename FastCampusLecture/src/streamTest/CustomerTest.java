package streamTest;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<Customer>();

        Customer customerLee = new Customer("이순신", 40, 100);
        Customer customerHong = new Customer("홍길동", 13, 100);
        Customer customerKim = new Customer("김유신", 20, 50);

        customerList.add(customerLee);
        customerList.add(customerHong);
        customerList.add(customerKim);

        customerList.stream().forEach(s -> System.out.println(s));
        System.out.println("==========================================");
        // 이름을 출력
        customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
        System.out.println("==========================================");
        // 고객 총 비용을 계산
        int total = customerList.stream().mapToInt(c -> c.getCost()).sum();
        System.out.println(total);
        System.out.println("==========================================");
        //
        customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));
    }

}
