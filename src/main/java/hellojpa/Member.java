package hellojpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    @ManyToOne //이거 중요!!! 한 팀에 여러명이 있을 수 있기에
    @JoinColumn(name="TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;


//    직접 할당: @Id만 사용
//    자동 생성(@GeneratedValue)
//    IDENTITY: 데이터베이스에 위임, MYSQL
//    SEQUENCE: 데이터베이스 시퀀스 오브젝트 사용, ORACLE
//    @SequenceGenerator 필요
//    TABLE: 키 생성용 테이블 사용, 모든 DB에서 사용
//    @TableGenerator 필요
//    AUTO: 방언에 따라 자동 지정, 기본값

//    @Column(name = "name", insertable =true, updatable = true)
//    //컬럼 매핑                 등록, 변경 가능 여부
////    nullable    null 값의 허용 여부를 설정한다. false로 설정하면 DDL 생성 시에 not null 제약조건이 붙는다.
////    unique      @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제 약조건을 걸 때 사용한다.
////    columnDefinition   데이터베이스 컬럼 정보를 직접 줄 수 있다.
////    length      문자 길이 제약조건, String 타입에만 사용한다.
////    precision, scale    BigDecimal 타입에서 사용한다(BigInteger도 사용할 수 있다). precision은 소수점을 포함한 전체 자릿수를,
////    scale은 소수의 자릿수다.
////        참고로 double, float 타입에는 적용되지 않는다. 아주 큰 숫자나 정 밀한 소수를 다루어야 할 때만 사용한다.
//    private String username;
//    private Integer age;
//    @Enumerated(EnumType.STRING)
//    //enum 타입 매핑
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    //날짜 타입 매핑
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    //BLOB, CLOB 매핑
//    private String description;
//
//    @Transient
//    private int temp;

    public Member() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    //    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teaId) {
//        this.teamId = teamId;
//    }


    //team에도 있을건데 두개 겹치면 무한루프 생성함
    @Override
    public String toString() {
        return "Team{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", team=" + team +
                '}';
    }

}
