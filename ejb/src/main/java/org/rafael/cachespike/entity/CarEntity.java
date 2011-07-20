package org.rafael.cachespike.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "car")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarEntity extends GenericEntity{
	
	@Id
	@GeneratedValue
	@XmlTransient
	protected Long id;

	@Column(name = "color")
	@XmlElement(name = "color")
	private String color;
	
	@Column(name = "model")
	@XmlElement(name = "model")
	private String model;
	
	@Version
	private Long version;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "(" + id + ", " + model + ", " + color + ")";
	}

}
