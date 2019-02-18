package com.example.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/18 12:49
 */
public class ConcreteMediator extends Mediator {

    private List<Colleague> colleagues = new ArrayList<Colleague>();

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    public void relay(Colleague colleague, String msg) {
        for (Colleague cl : colleagues) {
            if (!cl.equals(colleague)) {
                cl.receive(msg);
            }
        }
    }
}
