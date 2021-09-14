package dataSets;

import javax.persistence.*;

@Entity
@Table(name = "UserDataSet")
public class UserDataSet {

    @Id
    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "phoneNumber", unique = false, updatable = false)
    private int phoneNumber;


    public String getLogin() {
        return login;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
