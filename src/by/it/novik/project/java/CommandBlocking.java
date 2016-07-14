package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kate Novik.
 */
public class CommandBlocking implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.BLOCK.inPage;
        String id_account = request.getParameter("id_account");
        //ID счета получаем из параметра
        Integer id = Integer.parseInt(id_account);
        request.setAttribute("id_account",id_account);
        String reference = request.getParameter("reference");
        if (reference != null) {
            return page;
        }

        //Получаем объект DAO
        DAO dao = DAO.getDAO();
        Account account = dao.getAccountDAO().read(id);
        //Меняем поле счета на заблокированное
        account.setState("Lock");
        if (dao.getAccountDAO().update(account)) {
            request.setAttribute(Action.msgMessage, "Blocking of account" + id +" was done.");
            page = Action.BLOCK.okPage;
        }
        else {
            request.setAttribute(Action.msgMessage, "Blocking of account" + id + " wasn't done.");
            page = Action.BLOCK.inPage;
        }
        return page;
    }
}
