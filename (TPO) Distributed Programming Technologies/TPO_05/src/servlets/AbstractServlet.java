package servlets;

import exceptions.Tpo_05_exception;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public abstract class AbstractServlet extends HttpServlet{

    private static final String DATABASE_NAME_INIT_PARAM = "db_name";
    protected static final String CHARSET = "UTF-8";
    protected static final String TEXT_JSON_TYPE = "text/json";
    protected static final String TEXT_HTML_TYPE = "text/html";

    protected static final String USER = "user";
    protected static final String REQUEST_TYPE = "request";


    protected DataSource dataSource;

    @Override
    public void init() throws ServletException {
        String dbName = getInitParameter(DATABASE_NAME_INIT_PARAM);
        try {
            Context init = new InitialContext();
            Context jndiContext = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) jndiContext.lookup(dbName);
        } catch (NamingException e) {
            throw new Tpo_05_exception("Database not registered", e);
        }
    }

}
