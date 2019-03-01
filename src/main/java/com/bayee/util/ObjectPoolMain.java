package com.bayee.util;

/*
 * Created by renhongjiang on 2018/11/30.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/11/30 16:29
 */
abstract class ObjectPool<T> {
    private long expirationTime;

    private Hashtable<T, Long> locked, unlocked;

    public ObjectPool() {
        // 30 seconds
        this.expirationTime = 30000;
        this.locked = new Hashtable<T, Long>();
        this.unlocked = new Hashtable<T, Long>();
    }

    protected abstract T create();

    public abstract boolean validate(T o);

    public abstract void expire(T o);

    public synchronized T checkOut() {
        long now = System.currentTimeMillis();
        T t;
        if (unlocked.size() > 0) {
            Enumeration<T> e = unlocked.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unlocked.get(t)) > expirationTime) {
                    // object has expired
                    unlocked.remove(t);
                    expire(t);
                    t = null;
                } else {
                    if (validate(t)) {
                        unlocked.remove(t);
                        locked.put(t, now);
                        return t;
                    } else {
                        // object failed validation
                        unlocked.remove(t);
                        expire(t);
                        t = null;
                    }
                }
            }
        }
        // no objects available, create a new one
        t = create();
        locked.put(t, now);
        return t;
    }

    public synchronized void checkIn(T t) {
        locked.remove(t);
        unlocked.put(t, System.currentTimeMillis());
    }
}

class JDBCConnectionPool extends ObjectPool<Connection> {

    private String dsn, usr, pwd;

    public JDBCConnectionPool(String driver, String dsn, String usr, String pwd) {
        super();
        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dsn = dsn;
        this.usr = usr;
        this.pwd = pwd;
    }

    @Override
    protected Connection create() {
        try {
            return DriverManager.getConnection(dsn, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean validate(Connection o) {
        try {
            return !o.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void expire(Connection o) {
        try {
            o.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class ObjectPoolMain {
    public static void main(String[] args) {
        // Do something...

        // Create the ConnectionPool
        JDBCConnectionPool pool = new JDBCConnectionPool("org.hsqldb.jdbcDriver",
                "jdbc:hsqldb://localhost/mydb", "sa", "secret");

        // Get a connection
        Connection conn = pool.checkOut();

        // Use the connection


        // Return the connection
        pool.checkIn(conn);
    }

}