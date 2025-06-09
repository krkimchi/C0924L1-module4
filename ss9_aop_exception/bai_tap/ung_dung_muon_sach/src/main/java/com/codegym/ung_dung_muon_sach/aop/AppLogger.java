package com.codegym.ung_dung_muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppLogger {

    private int visitCount = 0;

    @AfterReturning("execution(* com.codegym.ung_dung_muon_sach.service.IBookService.*(..))")
    public void logBookChange(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        if (method.equals("decreaseQuantity") || method.equals("increaseQuantity")) {
            System.out.println("Hành động làm thay đổi sách: " + method);
        }
    }

    @Before("execution(* com.codegym.ung_dung_muon_sach.controller.*.*(..))")
    public void logAccess(JoinPoint joinPoint) {
        visitCount++;
        System.out.println("Số lượt truy cập thư viện: " + visitCount);
    }

    @AfterThrowing(pointcut = "execution(* com.codegym.ung_dung_muon_sach.controller.*.*(..))", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {
        System.out.println("Lỗi khi xử lý " + joinPoint.getSignature().getName() + ": " + ex.getMessage());
    }
}
