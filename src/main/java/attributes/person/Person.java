package attributes.person;

public class Person {
    private String name;
    private String identificationCard;
    private Address address;

    public String personToString(){
        return "Name: " + name + " ID card: " + identificationCard + " Addres: " + address.addressToString();
    }

    public void correctData(String name, String identificationCard, Address address){
        this.name = name;
        this.identificationCard = identificationCard;
        moveToAddress(address);
    }

    public void moveToAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
