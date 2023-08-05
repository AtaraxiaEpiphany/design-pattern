package org.example.chainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: LeaveRequest 请假条
 * @Author Hannibal
 * @Package org.example.chainOfResponsibility
 * @Date 05/08/2023 10:39
 * @Description: TODO
 */
@AllArgsConstructor
@Getter
public class LeaveRequest {
    private String name;
    private Integer days;
    private String reason;
}
