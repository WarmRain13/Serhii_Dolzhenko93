public class PhysicalPerson extends Client {
    private String name;

    public PhysicalPerson() {
        name = "";
        balance = 0.0;
    }

    public PhysicalPerson(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
