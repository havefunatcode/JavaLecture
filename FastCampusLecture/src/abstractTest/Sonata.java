package abstractTest;

public class Sonata extends Car {
    private String name = "Sonata";

    @Override
    public void start() {
        System.out.println(name + "시동을 켭니다.");
    }

    @Override
    public void drive() {
        System.out.println(name + "달립니다.");
    }

    @Override
    public void stop() {
        System.out.println(name + "멈춥니다.");
    }

    @Override
    public void turnoff() {
        System.out.println(name + "시동을 끕니다..");
    }
}
