package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // EntityManagerFactory를 생성하고 "hello"라는 이름의 영속성 단위를 기반으로 초기화
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager를 생성, 데이터베이스와 상호작용하는 데 사용
        EntityManager em = emf.createEntityManager();

        // 데이터베이스 작업을 위한 트랜잭션을 가져옴
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션을 시작
        tx.begin();

        try{
            //  비영속
        // 새로운 Member 객체를 생성
//        Member member = new Member();
//        // Member 객체의 ID를 1로 설정
//        member.setId(1L);
//        // Member 객체의 이름을 "hello"로 설정
//        member.setName("hello");

        // 생성한 Member 객체를 영속성 컨텍스트에 저장
//        em.persist(member);
//        //멤버를 찾을 때
//        Member fm = em.find(Member.class,1L);
//        //멤버 삭제
//        em.remove(fm);
//        //수정
//        fm.setName("HelloJPA");

        //
//        List<Member> result = em.createQuery("select m from Member as m",Member.class).getResultList();
//        for(Member m:result){
//            System.out.println(m.getName());
//        }

        // 트랜잭션을 커밋하여 변경 사항을 데이터베이스에 반영
            Team team = new Team();
            team.setName("Team 1");
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            team.addMember(member);

            //이게 꼭 붙어야함
            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());//1차 캐시
            List<Member> members = findTeam.getMembers();

            for(Member m : members){
                System.out.println(m.getUsername());
            }


//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members){
//                System.out.println("m = " + m.getUsername());
//            }

            //굉장히 객체지향스럽지 않다..?
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            //이렇게 해야함
//            Team findTeam = findMember.getTeam();

        tx.commit();
        }
        catch (Exception e){
            tx.rollback();
        }
        finally {
        // EntityManager를 닫음
        em.close();

        }
        // EntityManagerFactory를 닫dma.
        emf.close();

    }
}
