package com.my.test.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.my.test.core.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wuyingli
 * @since 2021/8/25
 */
@Api(tags = "公共查询")
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @GetMapping("/user-list")
    @ApiOperation("查询用户列表")
    public R<List> userList() {
        List<String> userNameList = ImmutableList.of("小王", "小李");
        return R.ok(userNameList);
    }
}
