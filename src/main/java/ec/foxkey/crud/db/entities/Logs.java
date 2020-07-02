package ec.foxkey.crud.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;
    @Column(nullable = false)
    private int type;
    @Column(nullable = false)
    private Timestamp day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getDay() {
        return day;
    }

    public void setDay(Timestamp day) {
        this.day = day;
    }

}
