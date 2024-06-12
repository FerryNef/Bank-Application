package bank.integration.logging;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface Logger {

    public void log (String logString);

}
