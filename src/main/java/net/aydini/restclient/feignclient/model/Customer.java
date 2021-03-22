package net.aydini.restclient.feignclient.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 23, 2021
 */

@Data
@NoArgsConstructor
public class Customer
{
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthDate;
}
