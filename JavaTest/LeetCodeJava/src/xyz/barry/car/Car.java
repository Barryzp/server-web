package xyz.barry.car;

/*
* 抽象类只是说不能够实例化，但是可以有具体方法和属性
* */
public abstract class Car implements IMoveable {
    public int getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(int engineNumber) {
        this.engineNumber = engineNumber;
    }

    int engineNumber;
    public abstract void startEngine();

}
