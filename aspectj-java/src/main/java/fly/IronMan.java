package fly;


import aspectj.Logged;

public class IronMan {
    @Logged
    public void fly() {
        System.out.println("-------I am Iron Man-------");
    }

    @Logged
    public void fall() {
        System.out.println("-------I love you 3000-------");
    }
}