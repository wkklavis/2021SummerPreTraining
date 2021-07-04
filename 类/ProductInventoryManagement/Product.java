package ProductInventoryManagement;

public class Product {
    private Double price;
    private Integer num;
    private String id;
    Product(String i,Integer n,Double p){
        id=i;num=n;price=p;
    }
    public Double getPrice(){
        return price;
    }
    public Integer getNum(){
        return num;
    }
    public String getId(){
        return id;
    }
    public Double sum(){
        return num*price;
    }
}
