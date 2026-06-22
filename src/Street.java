public class Street {

    private String name;
    private City city;

    public Street(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
    public String getCityName() {
        return city.getName();
    }
    public boolean isStartWithA(){
        return this.name.startsWith("A");
    }
}