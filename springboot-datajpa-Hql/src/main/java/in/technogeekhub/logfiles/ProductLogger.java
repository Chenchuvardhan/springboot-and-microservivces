package in.technogeekhub.logfiles;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductLogger {
public void productLogging() {
	log.info("logging info");
	log.error("error message");
	log.warn("warning");
}
}
