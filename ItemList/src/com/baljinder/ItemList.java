package com.baljinder;

public class ItemList extends Items {
    private Items rightLink = null;
    private Items leftLink = null;

    public ItemList(Object value){
        super(value);
    }

    @Override
    Items getRightLink() {
        return this.rightLink;
    }

    @Override
    Items getLeftLink() {
        return this.leftLink;
    }

    @Override
    Items setRightLink(Items newItem) {
        this.rightLink = newItem;
        return this.rightLink;
    }

    @Override
    Items setLeftLink(Items newItem) {
        this.leftLink = newItem;
        return this.leftLink;
    }


}
