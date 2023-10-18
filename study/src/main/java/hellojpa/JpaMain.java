package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // entityManage 줄여서 em
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());

            // 삭제
//            em.remove(findMember);

            // 수정
//            findMember.setName("HelloJPA");
            // JPQL
            // 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();

//            for (Member member: result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속
//            System.out.println("=====BEFORE======");
//            em.persist(member);
//            System.out.println("=====AFTER======");
            //준영속
//            em.detach(member);
            //삭제
//            em.remove(member);

//            Member findmember1 = em.find(Member.class, 101L);
//            Member findmember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findmember1 == findmember2));

            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            System.out.println("===================");
            tx.commit();
            System.out.println("===================");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
