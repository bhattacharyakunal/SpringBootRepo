/**
 * 
 */
package com.techworld.kunal.model.expense;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kunal
 *
 */
@Entity
@Table(name="EXPENSE_CATEGORY")
public class ExpenseCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long categotyId;
	private String categoryName;

	public Long getCategotyId() {
		return categotyId;
	}
	public void setCategotyId(Long categotyId) {
		this.categotyId = categotyId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
