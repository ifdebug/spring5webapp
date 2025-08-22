package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String publisherName;
    private String publisherEmail;

    @ManyToMany
    @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "publisher_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String publisherName, String publisherEmail) {
        this.publisherName = publisherName;
        this.publisherEmail = publisherEmail;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherEmail() {
        return publisherEmail;
    }

    public void setPublisherEmail(String publisherEmail) {
        this.publisherEmail = publisherEmail;
    }

    public  Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", publisherEmail='" + publisherEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;
        return Objects.equals(publisherName, publisher.publisherName) && Objects.equals(publisherEmail, publisher.publisherEmail);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(publisherName);
        result = 31 * result + Objects.hashCode(publisherEmail);
        return result;
    }
}
