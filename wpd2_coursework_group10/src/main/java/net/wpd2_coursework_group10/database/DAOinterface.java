package net.wpd2_coursework_group10.database;

import net.wpd2_coursework_group10.model.AccountLog;
import net.wpd2_coursework_group10.model.User;

import java.util.List;

public interface DAOinterface {

    public int varifyUser(String email, String password);

    public boolean isLogged(String email);

    public AccountLog getLog(String email);

    public List<AccountLog> getLogList(String email);

    public boolean createUserAccount(User user);

    public void resetAccPassword(String email);

    public void updateLogStatus(String email, String session);

    public String getSessionId(String email);

}
