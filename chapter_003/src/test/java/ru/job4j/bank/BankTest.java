package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("Slava", "401");
        bank.addUser(user);
        Set<User> result = bank.getUsers();
        assertThat(result.iterator().next().getName(), is("Slava"));
    }
    @Test
    public void whenRemoveUser() {
        Bank bank = new Bank();
        User user = new User("Slava", "401");
        bank.addUser(user);
        bank.deleteUser(user);
        Set<User> result = bank.getUsers();
        assertFalse(result.contains(user));
    }
    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Slava", "401"));
        bank.addAccountToUser("401", new Account(100d, "123"));
        double result = bank.getUserAccounts("401").get(0).getValue();
        assertThat(result, is(100d));
    }
    @Test
    public void whenRemoveAccountFromUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Slava", "401"));
        Account acc = new Account(100d, "123");
        bank.addAccountToUser("123", acc);
        bank.deleteAccountFromUser("123", acc);
        List<Account> result = bank.getUserAccounts("123");
        assertTrue(result.isEmpty());
    }
    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();
        bank.addUser(new User("Slava", "401"));
        Account acc = new Account(100d, "123");
        bank.addAccountToUser("401", acc);
        List<Account> result = bank.getUserAccounts("401");
        List<Account> expected = new ArrayList<>();
        expected.add(acc);
        assertThat(result, is(expected));
    }
    @Test
    public void whenTransferSucces() {
        Bank bank = new Bank();
        bank.addUser(new User("Slava", "401"));
        bank.addUser(new User("Vadim", "104"));
        Account acc = new Account(100d, "123");
        bank.addAccountToUser("401", acc);
        bank.addAccountToUser("104", new Account(10d, "1234"));
        bank.transferMoney("401", "123", "104", "1234", 50d);
        double result = bank.getUserAccounts("401").get(0).getValue();
        assertThat(result, is(50d));
    }
    @Test
    public void whenTransferDidNotSucces() {
        Bank bank = new Bank();
        bank.addUser(new User("Slava", "401"));
        bank.addUser(new User("Vadim", "104"));
        Account acc = new Account(100d, "123");
        bank.addAccountToUser("401", acc);
        bank.addAccountToUser("104", new Account(10d, "1234"));
        boolean result =  bank.transferMoney("401", "123", "104", "1234", 500d);
        assertFalse(result);
    }
}