package design.factory.prototype.deep;




import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ConcretePrototype implements Serializable {

    private int age;
    private String name;
    private List<String> hobbies;



    public ConcretePrototype deepClone(){
        try {

               JSONObject json = new JSONObject(this);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
