package dataSets;

import javax.persistence.*;

@Entity
@IdClass(UserCartDataSetKey.class)
@Table(name = "userCartDataSet")
public class UserCartDataSet {

    @Id
    @Column(name = "login", unique = false, updatable = false)
    private String login;
    @Id
    @Column(name = "thing", unique = true, updatable = false)
    private String thing;

    @Column(name = "count", unique = false, updatable = true)
    private int count;

    public String getLogin() {
        return login;
    }

    public String getThing() {
        return thing;
    }

    public int getCount() {
        return count;
    }
}
