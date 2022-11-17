import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ServerTest {

    Server server;
    Guest guest;

    @BeforeEach
    public void setUp(){
        server = new Server();
        server.addDrink("Aperol Spritz");
        server.addDrink("Martini");
        server.addDrink("Sex on the Beach");
        server.addDrink("Bloody Mary");
        server.addDrink("Screwdriver");
        server.addDrink("Old Fashioned");
        guest = new Guest("Andrew",19,10,69,false,'£',"Aperol Spritz");

    }

    // TODO: test that guest can only get served if over 18
    @Test
    public void isServed18__true(){
        assertThat(server.canServeGuest(guest)).isEqualTo(true);
    }
    @Test
    public void isServed18__false(){
        Guest specialGuest = new Guest("Peter",17,10,69,false,'£',"Martini");
        assertThat(server.canServeGuest(specialGuest)).isEqualTo(false);
    }
    // TODO: test that guest can only get served if has enough money to buy a drink (every drink is £5)
    @Test
    public void isServed18AndRich__false(){
        Guest specialGuest = new Guest("Peter",18,4,69,false,'£',"Sex on the Beach");
        assertThat(server.canServeGuest(specialGuest)).isEqualTo(false);
    }
    // TODO: test that guest can only get served if sober enough (set sobriety level on guest)
    @Test
    public void isServed18AndRichAndSober__false() {
        Guest specialGuest = new Guest("Peter",18,10,49,false,'£',"Bloody Mary");
        assertThat(server.canServeGuest(specialGuest)).isEqualTo(false);
    }
    // TODO: test that guest can only get served if guest is not banned from the pub
    @Test
    public void isServed18AndRichAndSoberAndAllowedIn__false() {
        Guest specialGuest = new Guest("Peter",18,10,49,true,'£',"Screwdriver");
        assertThat(server.canServeGuest(specialGuest)).isEqualTo(false);
    }
    // TODO: test that guest can only get served if guest can pay in local currency (add £ char as currency)
    @Test
    public void isServed18AndRichAndAllowedInAndLocalCurrency__false() {
        Guest specialGuest = new Guest("Peter", 18,10,69,false,'$',"Old Fashioned");
        assertThat(server.canServeGuest(specialGuest)).isEqualTo(false);
    }

    // EXTENSIONS

    // TODO: test that guest can only get served if server can make favourite drink
    //  (give server a list of drinks (strings) it can make)

    @Test
    public void isServed18AndRichAndAllowedInAndLocalCurrencyAndFavDrink__false() {
        Guest specialGuest = new Guest("Peter", 18,10,69,false,'£',"Pepsi");
        assertThat(server.canServeGuest(specialGuest)).isEqualTo(false);
    }

}
