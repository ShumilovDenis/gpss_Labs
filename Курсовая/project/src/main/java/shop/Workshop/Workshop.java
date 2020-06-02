package shop.Workshop;

import javax.persistence.*;

@Entity
@Table(name = "workshop")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWorkshop;
    private String workshopName;
    private String workshopChief;
    private int active;

    protected Workshop() {
    }

    public Workshop(String workshopName, String workshopChief) {
        this.workshopName = workshopName;
        this.workshopChief = workshopChief;
        this.active = 1;
    }

    public int getIdWorkshop() {
        return idWorkshop;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public String getWorkshopChief() {
        return workshopChief;
    }

    public int getActive() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("Наименование цеха: " + workshopName + "\n" +
                "Номер начальника цеха: " + workshopChief);
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public void setWorkshopChief(String workshopChief) {
        this.workshopChief = workshopChief;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setIdWorkshop(int idWorkshop) {
        this.idWorkshop = idWorkshop;
    }
}

