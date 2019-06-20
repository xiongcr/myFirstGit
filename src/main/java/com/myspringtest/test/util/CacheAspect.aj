package com.myspringtest.test.util;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
*@Auth xcr
* */

@Component
@Aspect
public class CacheAspect {

    private static HashMap hashMap;
    static {
        hashMap=new HashMap();
    }
    @Around("@annotation(com.myspringtest.test.util.MyCache)")
    public Object queryCache(ProceedingJoinPoint joinPoint)throws Throwable{
        String keyE1="";
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method=joinPoint.getTarget().getClass().getMethod(signature.getName(),signature.getMethod().getParameterTypes());
        MyCache myCache=method.getAnnotation(MyCache.class);
        keyE1=myCache.key();

        //1:创建解析器
        ExpressionParser parser=new SpelExpressionParser();
        Expression expression=parser.parseExpression(keyE1);

        //2:设置解析上下文（有哪些占位符，以及占位符的值）
        EvaluationContext context=new StandardEvaluationContext();


        //3;真实姓名（运行时获取的参数名：arg）
        Object[] args=joinPoint.getArgs();
        DefaultParameterNameDiscoverer discoverer=new DefaultParameterNameDiscoverer();
        String[] parameterNames=discoverer.getParameterNames(method);
        for (int i=0;i<args.length;i++){
            context.setVariable(parameterNames[i],args[i]);
        }
        //3:解析
        String key=expression.getValue(context).toString();

        Object value=hashMap.get(key);

        if(value!=null){
            System.out.printf("从缓存中取值。。。。。。。。。");
            return value;
        }

        //不存在执行数据库查询
        Object result=joinPoint.proceed();
        System.out.printf("方法执行之后。。。。。。。");

        //将数据同步到缓存中
        hashMap.put(key,result);
        return hashMap.get(key);



    }

}
