package attributes.person;

public class Address {
    private String country;
    private String city;
    private String streetAndNumber;
    private String zipCod;

    public Address(String country, String city, String streetAndNumber, String zipCod) {
        correctData( country, city, streetAndNumber, zipCod);
//        this.country = country;
//        this.city = city;
//        this.streetAndNumber = streetAndNumber;
//        this.zipCod = zipCod;
    }

    public String addressToString() {
        return String.format("Country: %s City: %s Street: %s ZIP: %s",
                country, city, streetAndNumber, zipCod);
    }

    public void correctData(String country, String city, String streetAndNumber, String zipCod){
        this.country = country;
        this.city = city;
        this.streetAndNumber = streetAndNumber;
        this.zipCod = zipCod;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getZipCod() {
        return zipCod;
    }
}
