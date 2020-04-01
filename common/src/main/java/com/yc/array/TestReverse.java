package com.yc.array;

import java.io.File;

/**
 * 递归方法测试
 *
 * @author gs
 * @date 2017年03月14日 11:11:28
 */
public class TestReverse {

    /**
     * 字符串反转
     *
     * @param inputStr
     * @return
     */
    private String reverseStr(String inputStr) {
        if (inputStr == null) {
            return null;
        }
        if (inputStr.length() <= 1) {
            return inputStr;
        } else {
            return inputStr.substring(inputStr.length() - 1, inputStr.length()) + reverseStr(inputStr.substring(0, inputStr.length() - 1));
        }
    }

    /**
     * 输出目录树状结构
     *
     * @param path
     * @param head
     * @throws Exception
     */
    private void tree(String path, String head) throws Exception {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(head + "├─" + f.getName());
            if (f.isDirectory()) {
                tree(f.getPath(), head + "│ ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "abdflkjdflj001";
        String path = "D:/Virtual Machines";

        TestReverse tr = new TestReverse();
        System.out.println(tr.reverseStr(str));

        try {
            tr.tree(path, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
