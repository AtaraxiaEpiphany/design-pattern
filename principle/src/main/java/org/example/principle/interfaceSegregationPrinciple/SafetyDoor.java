package org.example.principle.interfaceSegregationPrinciple;

import com.common.util.LogUtil;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: SafetyDoor 安全门
 * @Author Hannibal
 * @Package org.example.principle.interfaceSegregationPrinciple
 * @Date 23/07/2023 14:52
 * @Description: 按需实现功能接口
 */
public class SafetyDoor implements AntiTheft, FireProof, WaterProof {
    @Override
    public void antiTheft() {
        FG_YELLOW.print("防盗.");
    }

    @Override
    public void fireProof() {
        FG_YELLOW.print("防火.");
    }

    @Override
    public void waterProof() {
        FG_YELLOW.print("防水.");
    }

    public void run() {
        antiTheft();
        fireProof();
        waterProof();
    }
}
