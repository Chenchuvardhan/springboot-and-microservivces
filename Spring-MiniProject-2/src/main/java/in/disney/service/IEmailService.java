package in.disney.service;


public interface IEmailService {
public abstract boolean sendPasswordThroughEmail(String to,String Subject,String body);
}
