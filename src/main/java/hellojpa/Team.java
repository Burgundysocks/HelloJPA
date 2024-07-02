package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    //외래키가 있는 곳을 주인으로 하자!!!
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //멤버에 있는데 이거 두개 겹치면 무한루프 생성됨
    @Override
    public String toString() {
        return "Team{"
                + "id=" + id
                + ", username='" + name + '\''
                + ", members=" + members +
                '}';
    }
}
