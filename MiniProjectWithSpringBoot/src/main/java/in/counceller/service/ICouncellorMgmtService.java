package in.counceller.service;

import in.counceller.dto.CouncellorDto;

public interface ICouncellorMgmtService {
	public abstract CouncellorDto login(CouncellorDto councellorDto) throws Exception;
	public abstract boolean uniqueEmailCheck(String email);
	public abstract boolean register(CouncellorDto councellorDto)throws Exception;
}
