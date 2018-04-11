package com.baljinder;

public class Node {
    private Items root;

    public Node(Items newItem){
        this.root = newItem;
    }

    public Items getRoot(){
        return this.root;
    }

    public boolean addItem(Items newItem){
        if(this.root == null){
            this.root = newItem;
            return true;
        }else {
            Items currentItem = this.root;
            while (currentItem != null) {
                int comparison = Integer.parseInt(currentItem.getValue().toString())- Integer.parseInt(newItem.getValue().toString());
                if (comparison > 0) {
                    if (currentItem.getLeftLink() != null) {
                        currentItem.getLeftLink().setRightLink(newItem);
                        newItem.setLeftLink(currentItem.getLeftLink());
                        newItem.setRightLink(currentItem);
                        currentItem.setLeftLink(newItem);
                    } else {
                        currentItem.setLeftLink(newItem);
                        newItem.setRightLink(currentItem);
                        this.root = newItem;
                    }
                    return true;
                } else if (comparison < 0) {
                    if (currentItem.getRightLink() != null) {
                        currentItem = currentItem.getRightLink();
                    } else {
                        currentItem.setRightLink(newItem);
                        newItem.setLeftLink(currentItem);
                        return true;
                    }
                }else {
                    return false;
                }
            }
            return false;
        }
    }

    public boolean removeItem(Items newItem){
        if (this.root == null) {
            System.out.println("The list is empty");
            return false;
        } else {
            Items currentItem = this.root;
            while (currentItem != null) {
                int comparison = Integer.parseInt(currentItem.getValue().toString())- Integer.parseInt(newItem.getValue().toString());
                if (comparison == 0) {
                    if (currentItem.getLeftLink() == null) {
                        if (currentItem.getRightLink() != null) {
                            currentItem.getRightLink().setLeftLink(null);
                            this.root = currentItem.getRightLink();
                        } else {
                            this.root = null;
                        }
                    } else {
                        if (currentItem.getRightLink() == null) {
                            currentItem.getLeftLink().setRightLink(null);
                        } else {
                            currentItem.getLeftLink().setRightLink(currentItem.getRightLink());
                            currentItem.getRightLink().setLeftLink(currentItem.getLeftLink());
                        }
                    }
                    return true;
                } else if (comparison < 0) {
                    if (currentItem.getRightLink() != null) {
                        currentItem = currentItem.getRightLink();
                    } else {
                        // can't find it
                        return false;
                    }
                } else {
                    //already pass it
                    return false;
                }
            }
            return false;
        }
    }

    public void traverse(Items newItem){
        if(newItem == null){
            System.out.println("The list is empty");
        }else{
            while(newItem != null){
                System.out.print(newItem.getValue().toString());
                newItem = newItem.getRightLink();
                if(newItem != null){
                    System.out.print("-->");
                }
            }
            System.out.println();
        }
    }
}
