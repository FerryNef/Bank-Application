package bank.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class StopWatchAdvice {


    @Around("execution(public void bank.service.*.*(..))")
    public  Object calculate(ProceedingJoinPoint call) throws Throwable {

        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();

        sw.stop();

        long TotalTime=sw.getTotalTimeMillis();

        System.out.println("The time taken by: " +call.getSignature().getName() +" is: " +TotalTime +"ms");
        return retVal;

    }

}
