package com.example.command;

/**
 * @Description: 开灯命令对象
 * @author: cuixiuyin
 * @date: 2018/11/29 08:54
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
