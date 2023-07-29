package org.example.principle.principleOfLeastKnowleadge;

import com.common.util.LogUtil;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Agent 经纪人
 * @Author Hannibal
 * @Package org.example.principle.principleOfLeastKnowleadge
 * @Date 23/07/2023 15:14
 * @Description: TODO
 */
public class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public void meetFans() {
        FG_GREEN.print("%s和%s会面...", star.getName(), fans.getName());
    }

    public void business() {
        FG_GREEN.print("%s和%s洽谈...", star.getName(), company.getName());
    }


    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
