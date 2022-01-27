
public class Cat
{
    private static final int EYES = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double feedAmount;
    private static int count;
    Colour colour;
    private String name;
    private boolean isAlive = false;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;
        count++;
    }

    public Cat (double weight)
    {
        this();
        this.weight = weight;
    }

    public Cat(Double weight, double minWeight, double maxWeight, Colour colour, String name) {
        this();
        this.weight = weight;
        this.minWeight = getMinWeight();
        this.maxWeight = getMaxWeight();
        this.colour = getColour();
        this.name = name;
    }

    public  Cat(Cat other){
        this(other.getWeight(), other.getMinWeight(), other.getMaxWeight(), other.getColour(), other.getName());
    }

    public double getMinWeight()
    {
        return MIN_WEIGHT;
    }

    public double getMaxWeight()
    {
        return MAX_WEIGHT;
    }


    public static int getCount() {
        return count;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
        if (weight < minWeight) {
            count--;
        }
    }

    public void feed(Double amount) {

        if (isAlive()) {
            feedAmount = feedAmount + amount;
            weight = weight + amount;
        }
    }
    public boolean isAlive(){
     if(weight > MIN_WEIGHT && weight < MAX_WEIGHT){
         isAlive = true;
     }
     else if(isAlive){
             count--;
             isAlive = false;
         }

     return isAlive;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";

        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    // Урок 2

    public double FeedAmount() {
        return feedAmount;
    }

    public void pee() {
        weight = weight - 1;
        System.out.println("I peed");
    }
    //Урок 6

    public void setColour(Colour colour){
        this.colour = colour;
    }

    public Colour getColour(){
        return colour;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean isWeightNormal() { return (weight> MIN_WEIGHT && weight <MAX_WEIGHT); }
}