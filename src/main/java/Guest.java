public class Guest {

    private String name;
    private int age;
    private int money;
    private int sober;
    private boolean isBanned;
    private char currency;
    private String favDrink;

    public Guest(String name,
                 int age,
                 int money,
                 int sober,
                 boolean isBanned,
                 char currency,
                 String favDrink) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.sober = sober;
        this.isBanned = isBanned;
        this.currency = currency;
        this.favDrink = favDrink;

    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getMoney(){
        return this.money;
    }
    public int getSober(){
        return this.sober;
    }
    public boolean getIsBanned(){
        return this.isBanned;
    }
    public char getCurrency(){
        return this.currency;
    }
    public String getFavDrink(){
        return this.favDrink;
    }
}
