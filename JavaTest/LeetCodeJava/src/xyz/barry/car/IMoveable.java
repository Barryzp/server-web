package xyz.barry.car;

/*
* 定义接口，可以有实现的方法，在实现这个接口时，抽象方法必须实现，实具体方法可以不用重写
* */
public interface IMoveable {
    void move();

    public default void selfMove(){
        System.out.println("self started.");
    }
}
