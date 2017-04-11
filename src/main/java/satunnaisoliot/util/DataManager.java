/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import satunnaisoliot.datastructures.database.ReferenceDao;

/**
 *
 * @author juuso_j0pbwen
 */
public class DataManager {

    private static SqlDatastore datastore = null;
    private static ReferenceDao dao = new ReferenceDao(datastore);

    public static SqlDatastore getSqlDatastore() {
        if (datastore == null) {
            datastore = new SqlDatastore("referenceDB.db");
        }
        return datastore;
    }

    public static ReferenceDao getReferenceDao() {
        if (dao == null) {
            dao = new ReferenceDao(getSqlDatastore());
        }
        return dao;
    }

    public static void setDatabaseFileName(String name) {
        datastore = new SqlDatastore(name);
        dao = new ReferenceDao(datastore);
    }
}
