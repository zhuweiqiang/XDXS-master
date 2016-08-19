/* ===========================================================
 * $Id: AclClass.java 520 2009-08-27 05:59:23Z bitorb $
 * This file is part of Micrite
 * ===========================================================
 *
 * (C) Copyright 2009, by Gaixie.org and Contributors.
 * 
 * Project Info:  http://micrite.gaixie.org/
 *
 * Micrite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Micrite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Micrite.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
 
package com.qylm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 实体类对象。
 */
@Entity
@Table(name = "entityclass")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EntityClass extends BaseEntity {
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5137635231521840513L;
	
	/**
	 * CLS为class名字
	 */
	public static final String CLS = "cls";

	/**
     * 对用拦截的class名字
     * 所要操作的域对象类型
     */         
    @Column(name = "cls", nullable = false)
    private String cls;
    
    /**
     * No-arg constructor for JavaBean tools.
     */
    public EntityClass() {
        
    }

    /**
     * Full constructor
     */
    public EntityClass(String cls) {
        this.cls = cls;
    }
    
	/**
	 * @return the cls
	 */
	public String getCls() {
		return cls;
	}

	/**
	 * @param cls the cls to set
	 */
	public void setCls(String cls) {
		this.cls = cls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof EntityClass)) {
			return false;
		}
		EntityClass other = (EntityClass) object;
		return (this.id == null && other.id == null) ? super.equals(object)
				: (((this.id != null) || (other.id == null)) && ((this.id == null) || (this.id
						.equals(other.id))));
	}
    
}