package shop.Sellers;

import shop.Contacts.Contacts;
import shop.Post.Post;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSellers;
    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "id_contacts")
    private Contacts contacts;

    private int active;

    public Sellers(){
        this.active = 1;
    }

    public int getActive() {
        return active;
    }

    public Post getPost() {return post;}

    public Contacts getContacts() {return contacts;}

    public int getIdSellers() {return idSellers;}
    @Override
    public String toString(){
        return String.format(post + " " +contacts);
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setIdSellers(int idSellers) {
        this.idSellers = idSellers;
    }
}
