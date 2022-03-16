package uteq.freelancer_mvc.models;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int idcategory;

    @NotEmpty
    @Column(name = "name", length = 50)
    private String name;

    //todo: lista de formaciones
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = SubCategory.class)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Set<SubCategory> subCategory;

	/**
	 * @return the idcategory
	 */
	public int getIdcategory() {
		return idcategory;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the subCategory
	 */
	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}

	/**
	 * @param idcategory the idcategory to set
	 */
	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	
    
    
}
