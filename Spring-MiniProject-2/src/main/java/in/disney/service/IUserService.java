package in.disney.service;

import java.util.Map;

import in.disney.dto.Quote;
import in.disney.dto.ResetPasswordDto;
import in.disney.dto.UserDto;

public interface IUserService {
public abstract UserDto checkLogIn(String email,String password);
public abstract boolean isEmailUnique(String email);
public abstract Map<Integer,String> getCountries();
public abstract Map<Integer,String> getStates(Integer countryId);
public abstract Map<Integer,String> getCities(Integer cityId);
public abstract boolean registerUser(UserDto userDto);
public abstract Quote getQuote();
public abstract boolean resetPassword(ResetPasswordDto reset);
}
