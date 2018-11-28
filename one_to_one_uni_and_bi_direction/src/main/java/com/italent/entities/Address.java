/* In uni-direction there is no @OneToOne annotation in foreign integrity constraint(Address)
 * where as in bi-direction there a @OneToOne with attribute
 * mapped by that will refer to the property of primary constraint(Person)
 * 
 * To Implement bi directional mapping need to create one more property of type person and 
 * map the property with @OneToOne mapping and mentioning the attribute mappedBy with Perons's mapped property(address)
 * which s property of person entity.
 * 
 * should create default constructor to access the bidirectional data*/

package com.italent.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private Person person;

	public Address() {

	}

	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
