package oop;

public class Greeter {

    public String greet(String name) {
        name=name.trim();
        name=capitalizeFirstLetter(name);

        return "Hello "+name;
    }

    public String capitalizeFirstLetter(String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
