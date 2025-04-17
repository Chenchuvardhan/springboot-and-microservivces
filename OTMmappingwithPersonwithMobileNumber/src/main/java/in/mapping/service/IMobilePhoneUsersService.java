package in.mapping.service;

import in.mapping.entity.PhoneNumber;

public interface IMobilePhoneUsersService {
	public abstract void saveMobilePhoneUserWithPhoneNumbers();

	public abstract void FindAllThePhoneNumbers();

	public abstract void findChildsOnly(Integer id);
	public abstract void deleteChilds(PhoneNumber phno);
}
