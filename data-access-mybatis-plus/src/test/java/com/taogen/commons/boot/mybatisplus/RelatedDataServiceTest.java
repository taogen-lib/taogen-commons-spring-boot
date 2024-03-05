package com.taogen.commons.boot.mybatisplus;

import com.taogen.commons.boot.mybatisplus.samples.entity.User;
import com.taogen.commons.boot.mybatisplus.samples.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = AppTest.class)
@ExtendWith(SpringExtension.class)
class RelatedDataServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void setRelatedDataForList() {
        List<User> list = userService.list();
        assertNotNull(list);
        assertTrue(list.size() > 0);
        RelatedDataService.setRelatedDataForList(list, User.class);
        assertTrue(list.get(0).getDepartment() != null);
        assertTrue(!CollectionUtils.isEmpty(list.get(0).getHobbyList()));
        assertTrue(!CollectionUtils.isEmpty(list.get(0).getArea()));
        assertTrue(!CollectionUtils.isEmpty(list.get(0).getRoles()));
        System.out.println(list);
    }
}