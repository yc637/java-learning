package com.yc.string;

import lombok.ToString;

@ToString(callSuper = true)
public class SubStringTests extends StringTests {

    private int sex;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    public static void main(String[] args) {
        SubStringTests st = new SubStringTests();
        st.setName("1");
        st.setValue("2");
        st.setSex(3);
        System.out.println(st.toString());
    }

}
