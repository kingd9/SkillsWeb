package net.daneking.skillstool.person;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public
class Person {
	private String fname;
	private String lname;

}
