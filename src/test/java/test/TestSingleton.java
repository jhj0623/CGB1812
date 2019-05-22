package test;

/**
 * Created by CGB on 2019/4/13.
 */
//
class Singleton01{

    static class Lazy{
        public static final Singleton01 singleton=new Singleton01();
        public static Singleton01 getSingleton(){
            return Lazy.singleton;
        }
    }
}
public class TestSingleton {

    public static void main(String[] args){


    }
}
