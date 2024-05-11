package org.example.entity;

//菜单
public class Menu {

    //菜单名称
    private String menuName;

    //对应指令
    private String next;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
