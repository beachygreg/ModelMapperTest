package test.model.mapper;

import java.util.HashSet;
import java.util.Set;

/**
 * User: greg
 * Date: 13-07-22
 * Time: 10:26 AM
 */
public class ParentClassA {

    private Set<SubClassB> subClassBs = new HashSet<SubClassB>();


    public Set<SubClassB> getSubClassBs() {
        return subClassBs;
    }

    public void setSubClassBs(Set<SubClassB> subClassBs) {
        this.subClassBs = subClassBs;
    }

    public void addSubClassBs(SubClassB subClassB){
        subClassBs.add(subClassB);
    }
}
