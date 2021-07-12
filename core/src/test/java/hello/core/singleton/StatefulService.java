package hello.core.singleton;

public class StatefulService {
//    private int price;//state field

    public int order(String name, int price){
        System.out.println("name + \" price = \" + price = " + name + " price = " + price);
//        this.price = price;//here is the problem
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
