package com.crm.cust.buz.service.imp;

import com.crm.cust.CrmAdminApplition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmAdminApplition.class)
public class UmsAdminManagerServiceImpTest {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void updatePassword() {
        String newPassword = "123456";
        String str = passwordEncoder.encode(newPassword);
        System.out.println(str);
    }
}