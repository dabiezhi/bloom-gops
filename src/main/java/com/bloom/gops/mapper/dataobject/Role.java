package com.bloom.gops.mapper.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author taosy
 * Created by on 2022-01-20 下午5:44
 */
@Data
public class Role {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
}