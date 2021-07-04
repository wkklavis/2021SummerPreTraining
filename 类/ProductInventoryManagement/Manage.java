package ProductInventoryManagement;
import java.util.ArrayList;

public class Manage {
    private ArrayList<Product> store=new ArrayList<>();
    public void add(Product p){
        store.add(p);
    }
    public void getInfo(){
        for(int i=0;i<store.size();i++){
            System.out.println("产品名："+store.get(i).getId()+"  数量为: "+store.get(i).getNum()+"  价格为: "+store.get(i).getPrice());
        }
    }
    public Double getSum(){
        Double sum=0.0;
        for(int i=0;i<store.size();i++){
            sum+=store.get(i).sum();
        }
        return sum;
    }

}
