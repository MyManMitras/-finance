package mmm.service.finance.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import mmm.service.finance.model.Person;
import mmm.service.finance.model.PersonDetails;
import mmm.service.finance.repository.PersonRepository;

@Component
public class PersonDetailsService implements UserDetailsService{
	@Autowired
	private PersonRepository personRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepository.findByLoginID(username);
	
		System.out.println(username);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> permissions = Arrays.asList("Admin","Test");
        for (String permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
        }
        
		return new PersonDetails(person, grantedAuthorities);
	}

}
