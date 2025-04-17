package in.cipla.calci;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public int add(int i, int j) {
		return i + j;
	}
	public int mul(int i,int j) {
		return i*j;
	}
	public int sub(int i,int j) {
		return i-j;
	}
}


