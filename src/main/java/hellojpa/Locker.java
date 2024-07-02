package hellojpa;

import jakarta.persistence.*;

@Entity
public class Locker {
    //일대일
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy="locker")
    private Member member;
}
