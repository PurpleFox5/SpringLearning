package package1;

public abstract class Figure {

    private String name;

    public Figure(String name) {
        this.name = name;
        System.out.println("Bean " + name + " has been created");
    }

    public String getName() {
        return this.name;
    }

    public abstract double square();
}