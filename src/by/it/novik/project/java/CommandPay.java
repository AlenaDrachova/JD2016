package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.beans.Payment;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Kate Novik.
 */
public class CommandPay implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.PAY.inPage;
        //Получаем из сессии объект user
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //Поле суммы в форме пополнения счета
        String destination = request.getParameter("destination");
        String description = request.getParameter("description");
        String amount = request.getParameter("amount");
        //ID счета-источника платежа получаем из параметра
        Integer id_account = Integer.parseInt(request.getParameter("id_account"));
        request.setAttribute("id_account",id_account);
        //Если не введены данные, то возвращаем ту жу страницу
        if (amount == null || destination==null || description==null) {
            return page;
        }
        if (Validation.validDataFromForm(amount, "amount") && Validation.validDataFromForm(destination, "account")
                && Validation.validDataFromForm(description, "description")) {
            //Получаем объект DAO
            DAO dao = DAO.getDAO();
            //ID счета-получателя платежа получаем из параметра
            Integer id_destination = Integer.parseInt(request.getParameter("destination"));
            //Приводим сумму платежа к типу Double
            Double pay_amount = Double.parseDouble(amount);
            //Чтение счета-источника платежа по id
            Account account = dao.getAccountDAO().read(id_account);
            Double balance = account.getBalans();
            Account destination_account = dao.getAccountDAO().read(id_destination);
            //Проверим баланс счета для списывания денег
            if (balance >= pay_amount) {
                if (destination_account != null) {
                    //Вычислим сумму, которая останется на счете после списания
                    Double source_amount = balance - pay_amount;
                    account.setBalans(source_amount);
                    //Вычислим сумму, которая будет на счете получателя
                    Double destination_amount = destination_account.getBalans() + pay_amount;
                    destination_account.setBalans(destination_amount);

                    //Создание текущей даты и ее форматирование
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    String currentDate = formatDate.format(date);
                    //Создаем платежку
                    Payment payment;

                        payment = new Payment(0, id_account, description, id_destination, Date.valueOf(currentDate),
                                pay_amount);


                    if (dao.getAccountDAO().update(account) && dao.getPaymentDAO().create(payment) &&
                            dao.getAccountDAO().update(destination_account)) {
                        request.setAttribute(Action.msgMessage, "Payment was done.");
                        page = Action.PAY.okPage;
                    } else {
                        request.setAttribute(Action.msgMessage, "Payment wasn't done. Repeat, please, enter.");
                        page = Action.PAY.inPage;
                    }
                } else {
                    request.setAttribute(Action.msgMessage,"Account of destination doesn't exist. Repeat, please, enter.");
                    page = Action.PAY.inPage;
                }

            } else {
                request.setAttribute(Action.msgMessage,"Few funds in the account. Refill your account.");
                page = Action.PAY.inPage;
            }
        } else {
            request.setAttribute(Action.msgMessage,"Not valid data! Repeat, please, input.");
            page = Action.PAY.inPage;
        }
        return page;
    }
}
