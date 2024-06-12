package bank.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JMSLogAdvice {

    @Autowired
    private Logger logger;

@After("execution (public void bank.integration.jms.*.*(..))&& args(message)")
    public void logJMS(JoinPoint joinPoint, String message){
        logger.log("Message was sent" +message);
}
}
