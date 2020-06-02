package shop.Post;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPost;
    private String postDescr;
    private int salary;
    private int postHours;
    private int active;

    protected Post() {
    }

    public Post(String postDescr, int salary, int postHours) {
        this.postDescr = postDescr;
        this.salary = salary;
        this.postHours = postHours;
        this.active = 1;
    }

    public int getIdPost() {
        return idPost;
    }

    public String getPostDescr() {
        return postDescr;
    }

    public int getSalary() {
        return salary;
    }

    public int getPostHours() {
        return postHours;
    }

    public int getActive() {
        return active;
    }

    @Override
    public String toString() {
       return  String.format("Описание должности: " + postDescr + "%n"+
        "Оклад: " + salary);
    }

    public void setPostDescr(String postDescr) {
        this.postDescr = postDescr;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setPostHours(int postHours) {
        this.postHours = postHours;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
}

