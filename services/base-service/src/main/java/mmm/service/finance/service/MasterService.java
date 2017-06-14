package mmm.service.finance.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.OrganisationType;
import mmm.service.finance.model.Ownership;
import mmm.service.finance.model.Role;
import mmm.service.finance.repository.OrganisationTypeRepository;
import mmm.service.finance.repository.OwnershipRepository;
import mmm.service.finance.repository.RoleRepository;

@Component
public class MasterService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private OwnershipRepository ownershipRepository;
	
	@Autowired
	private OrganisationTypeRepository organisationTypeRepository;

	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<>();
		Iterable<Role> iterable = (Iterable<Role>) roleRepository.findAll();
		Iterator<Role> iterator = iterable.iterator();
		while(iterator.hasNext())
			roles.add(iterator.next());
		return roles;
	}
	
	public Role getRoleByName(String name){
		return roleRepository.findByName(name);
	}

	public List<Role> setRole(Role role) {
		roleRepository.save(role);
		
		return getRoles();
	}
	
	public List<Role> deleteRole(Role role) {
		Role roleToDelete = getRoleByName(role.getName());
		
		roleRepository.delete(roleToDelete);
		
		return getRoles();
	}
	
	public List<Ownership> getOwnerships() {
		List<Ownership> ownerships = new ArrayList<>();
		Iterable<Ownership> iterable = (Iterable<Ownership>) ownershipRepository.findAll();
		Iterator<Ownership> iterator = iterable.iterator();
		while(iterator.hasNext())
			ownerships.add(iterator.next());
		return ownerships;
	}
	
	public Ownership getOwnershipByName(String name){
		return ownershipRepository.findByName(name);
	}

	public List<Ownership> setOwnership(Ownership ownership) {
		ownershipRepository.save(ownership);
		
		return getOwnerships();
	}
	
	public List<Ownership> deleteOwnership(Ownership ownership) {
		Ownership ownershipToDelete = getOwnershipByName(ownership.getName());
		
		ownershipRepository.delete(ownershipToDelete);
		
		return getOwnerships();
	}
	
	
	public List<OrganisationType> getOrganisationTypes() {
		List<OrganisationType> organisationTypes = new ArrayList<>();
		Iterable<OrganisationType> iterable = (Iterable<OrganisationType>) organisationTypeRepository.findAll();
		Iterator<OrganisationType> iterator = iterable.iterator();
		while(iterator.hasNext())
			organisationTypes.add(iterator.next());
		return organisationTypes;
	}
	
	public OrganisationType getOrganisationTypeByName(String name){
		return organisationTypeRepository.findByName(name);
	}

	public List<OrganisationType> setOrganisationType(OrganisationType organisationType) {
		organisationTypeRepository.save(organisationType);
		
		return getOrganisationTypes();
	}
	
	public List<OrganisationType> deleteOrganisationType(OrganisationType organisationType) {
		OrganisationType organisationTypeToDelete = getOrganisationTypeByName(organisationType.getName());
		
		organisationTypeRepository.delete(organisationTypeToDelete);
		
		return getOrganisationTypes();
	}
}
