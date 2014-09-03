package net.daneking.skillstool.person;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Person implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6871005242950374577L;
	private String fname;
	private String lname;

}
