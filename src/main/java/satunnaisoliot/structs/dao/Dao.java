/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.structs.dao;

import java.util.List;
import satunnaisoliot.gui.UpdatableGui;

import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;

/**
 *
 * @author jambo
 */
public interface Dao {
    public void addReference(Reference ref);
    public List<Reference> findAll();
    public int rowcount();
    public int countReferenceswithSameBibTexKey(String bibTexKey);
    public void setMainTableUpdateThing(UpdatableGui thing);
}
