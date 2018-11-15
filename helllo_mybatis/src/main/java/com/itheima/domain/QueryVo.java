package com.itheima.domain;

public class QueryVo {

    private User user;

    public User getUser() {

        System.out.println("getUser()---->"+user);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
