package com.customer.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "UserBank")
public class UserBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    @Column(name = "accountnumber")
    private long accountnumber;

    @Column(name = "bankbranch")
    private String bankbranch;

    @Column(name = "accounttype")
    private String accounttype;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "userBank")
    @JoinColumn(name = "uid")
    @JsonBackReference
    private User user;


    public UserBank(long uid, long accountnumber, String bankbranch, String accounttype, User user) {
        this.uid = uid;
        this.accountnumber = accountnumber;
        this.bankbranch = bankbranch;
        this.accounttype = accounttype;
        this.user = user;
    }

    public UserBank() {
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBankbranch() {
        return bankbranch;
    }

    public void setBankbranch(String bankbranch) {
        this.bankbranch = bankbranch;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserBank{" +
                "uid=" + uid +
                ", accountnumber=" + accountnumber +
                ", bankbranch='" + bankbranch + '\'' +
                ", accounttype='" + accounttype + '\'' +
                ", user=" + user +
                '}';
    }
}
