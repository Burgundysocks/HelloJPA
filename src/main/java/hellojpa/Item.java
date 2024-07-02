package hellojpa;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("A")//default EntityName
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

}
