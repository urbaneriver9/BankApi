package dto;

import domain.Account;
import domain.Client;

import java.util.List;

public class ClientDto {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phoneNumber;
    private List<Account> accounts;
//    private List<Client> counterparties;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

//    public List<Client> getCounterparties() {
//        return counterparties;
//    }
//
//    public void setCounterparties(List<Client> counterparties) {
//        this.counterparties = counterparties;
//    }

}
