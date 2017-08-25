package mmm.service.finance.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mmm.service.finance.model.CollectionFrequency;
import mmm.service.finance.model.CompoundingFrequency;
import mmm.service.finance.model.FirmType;
import mmm.service.finance.model.PaymentMode;
import mmm.service.finance.model.Service;
import mmm.service.finance.model.Status;
import mmm.service.finance.model.Role;
import mmm.service.finance.repository.ServiceRepository;
import mmm.service.finance.repository.StatusRepository;
import mmm.service.finance.repository.CollectionFrequencyRepository;
import mmm.service.finance.repository.CompoundingFrequencyRepository;
import mmm.service.finance.repository.FirmTypeRepository;
import mmm.service.finance.repository.PaymentModeRepository;
import mmm.service.finance.repository.RoleRepository;

@Component
public class MasterService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private FirmTypeRepository firmTypeRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private CompoundingFrequencyRepository compoundingFrequencyRepository;
	
	@Autowired
	private CollectionFrequencyRepository collectionFrequencyRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private PaymentModeRepository paymentModeRepository;
	
	public List<CompoundingFrequency> getCompundingFrequencies() {
		List<CompoundingFrequency> compoundingFrequencies = new ArrayList<>();
		Iterable<CompoundingFrequency> iterable = (Iterable<CompoundingFrequency>) compoundingFrequencyRepository.findAll();
		Iterator<CompoundingFrequency> iterator = iterable.iterator();
		while(iterator.hasNext())
			compoundingFrequencies.add(iterator.next());
		return compoundingFrequencies;
	}
	
	public CompoundingFrequency getCompoundingFrequencyByName(String name){
		return compoundingFrequencyRepository.findByName(name);
	}
	
	public  List<CompoundingFrequency> setCompoundingFrequency(CompoundingFrequency compoundingFrequency){
		compoundingFrequencyRepository.save(compoundingFrequency);
		return getCompundingFrequencies();
	}
	
	public  List<CompoundingFrequency> deleteCompoundingFrequency(CompoundingFrequency compoundingFrequency){
		CompoundingFrequency compoundingFrequencyToDelete = getCompoundingFrequencyByName(compoundingFrequency.getName());
		compoundingFrequencyRepository.delete(compoundingFrequencyToDelete);
		return getCompundingFrequencies();
	}
	
	public List<CollectionFrequency> getCollectionFrequencies() {
		List<CollectionFrequency> collectionFrequencies = new ArrayList<>();
		Iterable<CollectionFrequency> iterable = (Iterable<CollectionFrequency>) collectionFrequencyRepository.findAll();
		Iterator<CollectionFrequency> iterator = iterable.iterator();
		while(iterator.hasNext())
			collectionFrequencies.add(iterator.next());
		return collectionFrequencies;
	}
	
	public CollectionFrequency getCollectionFrequencyByName(String name){
		return collectionFrequencyRepository.findByName(name);
	}
	
	public  List<CollectionFrequency> setCollectionFrequency(CollectionFrequency collectionFrequency){
		collectionFrequencyRepository.save(collectionFrequency);
		return getCollectionFrequencies();
	}
	
	public  List<CollectionFrequency> deleteCollectionFrequency(CollectionFrequency collectionFrequency){
		CollectionFrequency collectionFrequencyToDelete = getCollectionFrequencyByName(collectionFrequency.getName());
		collectionFrequencyRepository.delete(collectionFrequencyToDelete);
		return getCollectionFrequencies();
	}
	
	public List<Status> getStatuses() {
		List<Status> statuses = new ArrayList<>();
		Iterable<Status> iterable = (Iterable<Status>) statusRepository.findAll();
		Iterator<Status> iterator = iterable.iterator();
		while(iterator.hasNext())
			statuses.add(iterator.next());
		return statuses;
	}
	
	public Status getStatusByName(String name){
		return statusRepository.findByName(name);
	}
	
	public  List<Status> setStatus(Status status){
		statusRepository.save(status);
		return getStatuses();
	}
	
	public  List<Status> deleteStatus(Status status){
		Status statusToDelete = getStatusByName(status.getName());
		statusRepository.delete(statusToDelete);
		return getStatuses();
	}
	
	public List<PaymentMode> getPaymentModes() {
		List<PaymentMode> paymentModes = new ArrayList<>();
		Iterable<PaymentMode> iterable = (Iterable<PaymentMode>) paymentModeRepository.findAll();
		Iterator<PaymentMode> iterator = iterable.iterator();
		while(iterator.hasNext())
			paymentModes.add(iterator.next());
		return paymentModes;
	}
	
	public PaymentMode getPaymentModeByName(String name){
		return paymentModeRepository.findByName(name);
	}
	
	public  List<PaymentMode> setStatus(PaymentMode paymentMode){
		paymentModeRepository.save(paymentMode);
		return getPaymentModes();
	}
	
	public  List<PaymentMode> deleteStatus(PaymentMode paymentMode){
		PaymentMode paymentModeToDelete = getPaymentModeByName(paymentMode.getName());
		paymentModeRepository.delete(paymentModeToDelete);
		return getPaymentModes();
	}
	
	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<>();
		Iterable<Role> iterable = (Iterable<Role>) roleRepository.findAll();
		Iterator<Role> iterator = iterable.iterator();
		while(iterator.hasNext())
			roles.add(iterator.next());
		return roles;
	}
	
	public List<String> getRolesList() {
		List<String> roles = new ArrayList<>();
		Iterable<Role> iterable = (Iterable<Role>) roleRepository.findAll();
		Iterator<Role> iterator = iterable.iterator();
		while(iterator.hasNext())
			roles.add(iterator.next().getName());
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
	
	public List<String> getOwnershipsList() {
		List<String> ownerships = new ArrayList<>();
		Iterable<FirmType> iterable = (Iterable<FirmType>) firmTypeRepository.findAll();
		Iterator<FirmType> iterator = iterable.iterator();
		while(iterator.hasNext())
			ownerships.add(iterator.next().getName());
		return ownerships;
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
	
	public List<String> getOrganisationTypesList() {
		List<String> organisationTypes = new ArrayList<>();
		Iterable<Service> iterable = (Iterable<Service>) serviceRepository.findAll();
		Iterator<Service> iterator = iterable.iterator();
		while(iterator.hasNext())
			organisationTypes.add(iterator.next().getName());
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
