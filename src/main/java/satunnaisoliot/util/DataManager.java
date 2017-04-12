/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import satunnaisoliot.structs.dao.Dao;
import satunnaisoliot.structs.dao.ReferenceDao;

/**
 *
 * @author juuso_j0pbwen
 */
public class DataManager {

    private static SqlDatastore datastore = null;
    private static Dao dao = null;

    public static SqlDatastore getSqlDatastore() {
        if (datastore == null) {
            datastore = new SqlDatastore("referenceDB.db");
        }
        return datastore;
    }

    public static Dao getDao() {
        if (dao == null) {
            dao = new ReferenceDao(getSqlDatastore());
        }
        return dao;
    }

    public static void setDatabaseFileName(String name) {
        datastore = new SqlDatastore(name);
        dao = new ReferenceDao(datastore) {};
    }
}
