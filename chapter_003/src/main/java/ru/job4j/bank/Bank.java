package ru.job4j.bank;

import java.util.*;

/**
 * @author Viacheslav Bulatov (bul290896@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    /**
     * Отображение клиентов банка
     */
    private Map<User, List<Account>> users;

    /**
     * Конструктор создания банка
     */
    public Bank() {
        this.users = new HashMap<>();
    }

    /**
     * Добавляет клиента банка
     * @param user клиент
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет клиента банка
     * @param user клиент
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Возвращает список клиентов банка
     * @return список клиентов банка
     */
    public Set<User> getUsers() {
        return this.users.keySet();
    }

    /**
     * Добавляет счет клиенту
     * @param passport паспорт клиента
     * @param account новый счет клиента
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> i : this.users.entrySet()) {
            if (i.getKey().getPasport().equals(passport)) {
                i.getValue().add(account);
                break;
            }
        }
    }
    /**
     * Удаляет счет клиента
     * @param passport паспорт клиента
     * @param account счет клиента, который нужно удалить
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> i : this.users.entrySet()) {
            if (i.getKey().getPasport().equals(passport)) {
                i.getValue().remove(account);
                break;
            }
        }
    }

    /**
     * Возвращает список счетов данного клиента
     * @param passport паспорт клиента
     * @return список счетов клиента
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> i : this.users.entrySet()) {
            if (i.getKey().getPasport().equals(passport)) {
                result = i.getValue();
                break;
            }
        }
        return result;
    }

    /**
     * Осуществляет перевод средств с одного счета на другой
     * @param srcPassport паспортные данные отправителья
     * @param srcRequisite номер счета отправителя
     * @param dstPassport паспортные данные получателя
     * @param dstRequisite номер счета получаетля
     * @param amount размер перевода
     * @return true - если перевод произведен успешно, false - в противном случае
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String dstPassport, String dstRequisite,
                                  double amount) {
        boolean result = false;
        Optional<User> src = this.getUser(srcPassport);
        Optional<User> dst = this.getUser(dstPassport);
        if (src.isPresent() && dst.isPresent()) {
            User source = src.get();
            User dest = dst.get();
            Optional<Account> sAcc = this.getAccount(source, srcRequisite);
            Optional<Account> dAcc = this.getAccount(dest, dstRequisite);
            if (sAcc.isPresent() && dAcc.isPresent()) {
                Account srcAcc = sAcc.get();
                Account destAcc = dAcc.get();
                result = srcAcc.transfer(destAcc, amount);
            }
        }
        return result;
    }

    /**
     * Поиск клиента по паспорту
     * @param pasport паспорт клиента
     * @return клиент
     */
    private Optional<User> getUser(String pasport) {
        Optional<User> result = Optional.empty();
        for (User user : this.users.keySet()) {
            if (user.getPasport().equals(pasport)) {
                result = Optional.of(user);
                break;
            }
        }
        return result;
    }

    /**
     * Поиск счета данного клиента по реквизитам
     * @param user клиент
     * @param reqs реквизиты счета
     * @return счет
     */
    private Optional<Account> getAccount(User user, String reqs) {
        Optional<Account> result = Optional.empty();
        for (Account acc : this.getUserAccounts(user.getPasport())) {
            if (acc.getRequisites().equals(reqs)) {
                result = Optional.of(acc);
                break;
            }
        }
        return result;
    }
}
