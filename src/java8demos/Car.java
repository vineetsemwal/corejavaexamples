package java8demos;

public class Car {

    private String name;

    public Car(){
        this("name not provided");
    }
    public Car(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
