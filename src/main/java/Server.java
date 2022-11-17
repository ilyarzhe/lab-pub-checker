import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<String> drinksServed;
    public Server(){
        this.drinksServed = new ArrayList<>();
    }

    public boolean canServeGuest(Guest guest){
        if (guest.getAge()<18){
            return false;
        }
        if (guest.getMoney()<5){
            return false;
        }
        if (guest.getSober()<50){
            return false;
        }
        if (guest.getIsBanned()){
            return false;
        }
        if (guest.getCurrency()!='£'){
            return false;
        }
        if (!this.servesGuestDrink(guest)){
            return false;
        }
        return true;
    }
    public List<String> getDrinksServed(){
        return this.drinksServed;
    }
    public void addDrink(String drink){
        this.drinksServed.add(drink);
    }
    public boolean servesGuestDrink(Guest guest){
        for (String drink:this.drinksServed){
            if (guest.getFavDrink().equalsIgnoreCase(drink)){
                return true;
            }
        }
        return false;
    }

}
