package com.baljinder;

public abstract class Items {
    protected Object value;

    public Items(Object value){
        this.value = value;
    }

    public Object getValue(){
        return this.value;
    }

    abstract Items getRightLink();
    abstract Items getLeftLink();
    abstract Items setRightLink(Items newItem);
    abstract Items setLeftLink(Items newItem);
}
