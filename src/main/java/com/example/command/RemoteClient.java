package com.example.command;

/**
 * @Description: 客户端
 * @author: cuixiuyin
 * @date: 2018/11/29 09:27
 */
public class RemoteClient {

    public static void main(String[] args) {
        // 1、创建接收者
        Light light = new Light();
        // 2、创建命令对象
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        // 3、创建一组开关并用命令对象装载它
        RemoteInvoker invoker = new RemoteInvoker(1);
        invoker.setCommond(0, lightOnCommand, lightOffCommand);
        // 4、测试
        invoker.onButton(0);
        invoker.offButton(0);
        invoker.undoButton();
    }
}
