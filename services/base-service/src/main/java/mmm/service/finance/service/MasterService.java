package mmm.service.finance.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.FirmType;
import mmm.service.finance.model.Service;
import mmm.service.finance.model.Role;
import mmm.service.finance.repository.ServiceRepository;
import mmm.service.finance.repository.FirmTypeRepository;
import mmm.service.finance.repository.RoleRepository;

@Component
public class MasterService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private FirmTypeRepository firmTypeRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;

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
	
	public List<FirmType> getOwnerships() {
		List<FirmType> ownerships = new ArrayList<>();
		Iterable<FirmType> iterable = (Iterable<FirmType>) firmTypeRepository.findAll();
		Iterator<FirmType> iterator = iterable.iterator();
		while(iterator.hasNext())
			ownerships.add(iterator.next());
		return ownerships;
	}
	
	public FirmType getOwnershipByName(String name){
		return firmTypeRepository.findByName(name);
	}

	public List<FirmType> setOwnership(FirmType ownership) {
		firmTypeRepository.save(ownership);
		
		return getOwnerships();
	}
	
	public List<FirmType> deleteOwnership(FirmType ownership) {
		FirmType ownershipToDelete = getOwnershipByName(ownership.getName());
		
		firmTypeRepository.delete(ownershipToDelete);
		
		return getOwnerships();
	}
	
	
	public List<Service> getOrganisationTypes() {
		List<Service> organisationTypes = new ArrayList<>();
		Iterable<Service> iterable = (Iterable<Service>) serviceRepository.findAll();
		Iterator<Service> iterator = iterable.iterator();
		while(iterator.hasNext())
			organisationTypes.add(iterator.next());
		return organisationTypes;
	}
	
	public Service getOrganisationTypeByName(String name){
		return serviceRepository.findByName(name);
	}

	public List<Service> setOrganisationType(Service organisationType) {
		serviceRepository.save(organisationType);
		
		return getOrganisationTypes();
	}
	
	public List<Service> deleteOrganisationType(Service organisationType) {
		Service organisationTypeToDelete = getOrganisationTypeByName(organisationType.getName());
		
		serviceRepository.delete(organisationTypeToDelete);
		
		return getOrganisationTypes();
	}
}
