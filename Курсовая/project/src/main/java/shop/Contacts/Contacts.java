package shop.Contacts;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContacts;
    private String email;
    private String phoneNumber;
    private int active;

    protected Contacts() {
    }

    public Contacts(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.active = 1;
    }

    public int getIdContacts() {
        return idContacts;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getActive() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("Мэйл: " + email + "\n" +
                "Телефон: " + phoneNumber);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setIdContacts(int idContacts) {
        this.idContacts = idContacts;
    }
}

