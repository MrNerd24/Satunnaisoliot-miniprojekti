/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.structs.dao;

import satunnaisoliot.structs.interfaces.Reference;

import java.util.List;

/**
 *
 * @author jambo
 */
public interface Dao {
    public void addReference(Reference ref);
    public void deleteReference(Reference ref);
    public List<Reference> findAll();
    public int rowcount();
    public int countReferenceswithSameBibTexKey(String bibTexKey);
    public List<Reference> findAllContainingString(String searchTerm);
}
