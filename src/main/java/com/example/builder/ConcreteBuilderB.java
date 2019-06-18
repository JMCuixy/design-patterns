package com.example.builder;

/***
 * @Description 具体建造者B
 * @author xiuyin.cui
 * @date 2019/02/14 16:20
 *
 * @return
 */
public class ConcreteBuilderB implements Builder {

    private House house;

    public ConcreteBuilderB() {
        this.house = new House();
        buildFoundation();
        buildWall();
        buildRoof();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("B建造者打的地基");
    }

    @Override
    public void buildWall() {
        house.setWall("B建造者砌的墙");

    }

    @Override
    public void buildRoof() {
        house.setRoof("B建造者盖的屋顶");

    }

    @Override
    public House getHouse() {
        return house;
    }
}
