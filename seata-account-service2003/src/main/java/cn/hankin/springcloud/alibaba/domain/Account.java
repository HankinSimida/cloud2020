package cn.hankin.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hankin
 * @date 2020/4/4 15:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
