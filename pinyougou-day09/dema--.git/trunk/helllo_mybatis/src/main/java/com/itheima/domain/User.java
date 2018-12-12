package com.itheima.domain;

import java.util.Date;

/*
        构建者模式：作用：解决组合复杂对象的组合过程

 */
public class User {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    //getter getter


    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }


    public static class Builder {

        private Integer id;
        private String username;
        private Date birthday;
        private String sex;
        private String address;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setBirthday(Date birthday) {

            this.birthday = birthday;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {


            return new User(this.id, this.username, this.birthday, this.sex, this.address);
        }

    }







    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        System.out.println("setId()---->"+id);
        this.id = id;
    }

    //#{username}  ognl
    public String getUsername() {

        System.out.println("getUsername()--->"+username);
        return username;
    }

    public void setUsername(String username) {

        System.out.println("setUsername()--->"+username);
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {

        System.out.println("setSex()--->"+sex);
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        System.out.println("setAddress()---->"+address);
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
     }
  }
