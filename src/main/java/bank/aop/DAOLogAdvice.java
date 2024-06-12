package bank.aop;

import bank.domain.Account;
import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DAOLogAdvice {

    @Autowired
    private Logger logger;

    @After("execution(public void bank.repository.*.*(..)) && args(account)")
    public void log (JoinPoint joinpoint , Account account)
    {
        logger.log("Call was made by: " + joinpoint.getSignature().getName()
                        + " " +"on: " + account.getAccountNumber());
    }

}
