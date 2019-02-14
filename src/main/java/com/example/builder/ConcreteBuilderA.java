package com.example.builder;

/***
 * @Description 具体建造者A
 * @author xiuyin.cui
 * @date 2019/02/14 16:20
 *
 * @return
 */
public class ConcreteBuilderA implements Builder {

    private House house;

    public ConcreteBuilderA() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("A建造者打的地基");
    }

    @Override
    public void buildWall() {
        house.setWall("A建造者砌的墙");

    }

    @Override
    public void buildRoof() {
        house.setRoof("A建造者盖的屋顶");

    }

    @Override
    public House getHouse() {
        return house;
    }
}
