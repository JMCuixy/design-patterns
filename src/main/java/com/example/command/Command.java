package com.example.command;

/**
 * @Description: 抽象命令
 * @author: cuixiuyin
 * @date: 2018/11/29 08:47
 */
public interface Command {
    /**
     * 执行命令
     */
    void execute();

    /**
     * 撤销命令
     */
    void undo();
}
