package extendTest;

public class Car {
    private String name;

    public void start(String name)  {
        System.out.println(name + "시동을 켭니다.");
    }
    public void drive(String name)  {
        System.out.println(name + "달립니다.");
    }
    public void stop(String name)   {
        System.out.println(name + "멈춥니다.");
    }
    public void turnoff(String name)    {
        System.out.println(name + "시동을 끕니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(String name)  {
        start(name);
        drive(name);
        stop(name);
        turnoff(name);
    }
}
