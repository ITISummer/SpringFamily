package com.itis.spring4.hibernate.pojo;

/**
 * @ClassName Account
 * @Author LCX
 * @Date 2021 2021-06-06 10:08 a.m.
 * @Version 1.0
 **/
public class Account {
    private Integer id;
    private String username;
    private Integer balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
