package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    //주소
    private String city;
    private String street;

    @Column(name="ZIPCODE")// 이렇게 대문자도 가능함
    private String zipcode;

    public Address(){

    }

    public Address(String city, String street, String zipcode) {
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }



    public String getStreet() {
        return street;
    }



    public String getZipcode() {
        return zipcode;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
