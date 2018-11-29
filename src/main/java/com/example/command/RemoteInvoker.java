package com.example.command;

/**
 * @Description: 调用者
 * @author: cuixiuyin
 * @date: 2018/11/29 09:01
 */
public class RemoteInvoker {

    /**
     * 开关命令数组，模拟有很多对开关数组
     */
    private Command[] onCommands;
    private Command[] offCommands;
    /**
     * 撤销（回退）命令
     */
    private Command undoCommand;

    public RemoteInvoker(int length) {
        // 有几组开关，就设置多少数组
        onCommands = new Command[length];
        offCommands = new Command[length];
        // 把每个命令初始化成空命令，避免空指针异常
        Command noCommand = new NoCommand();
        undoCommand = noCommand;
        for (int i = 0; i < length; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /***
     * @Description 设置命令对象
     * @author cuixiuyin
     * @date 2018/11/29 09:15
     * @param slot 遥控器的位置
     * @param onCommand 开的命令
     * @param offCommand 关的命令
     * @return void
     */
    public void setCommond(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }


    public void onButton(int slot) {
        onCommands[slot].execute();
        //为撤销（回退）按钮记录动作
        undoCommand = onCommands[slot];
    }

    public void offButton(int slot) {
        offCommands[slot].execute();
        //为撤销（回退）按钮记录动作
        undoCommand = offCommands[slot];
    }

    public void undoButton() {
        undoCommand.undo();
    }
}
