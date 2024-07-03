package hellojpa;

public class ValueMain {

    public static void main(String[] args) {
//        //int의 경우
//        int a = 10;
//        int b = a;
//
//        a = 20;
//
//        System.out.println(a); // 20
//        System.out.println(b); // 10
//        //a 값을 변경해도 사이드 이펙트가 없음

        Integer a = 10;
        Integer b = a;

        a = 20;


        System.out.println(a); // 20
        System.out.println(b); // 10\
        //만약 setValue같은 메소드가 있어서 a.setValue(20)을 하면 다 20이 됨
        //그럼 b의 값을 되돌릴 방법이 없음



    }

}
