import lombok.Data;

class Cat {
    public void shout() {
        System.out.println("wa wa ~");
    }
}

class Dog {
    public void shout() {
        System.out.println("dong dong ~");
    }
}

@Data
public class People {
    private Dog dog;
    private Cat cat;

    @Override
    public String toString() {
        return "People{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
