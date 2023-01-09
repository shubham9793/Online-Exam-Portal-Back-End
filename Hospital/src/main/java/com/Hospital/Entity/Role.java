package com.Hospital.Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Role {
    @Id
    
    private Long roleid;
    
    private String roleName;
    
    // one role can be assign to multiple person 
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    
    
    
    public Role() {
    }

    public Role(Long roleid, String roleName) {
        this.roleid = roleid;
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
