package com.example.command;

/**
 * @Description: 关灯命令对象
 * @author: cuixiuyin
 * @date: 2018/11/29 08:57
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
