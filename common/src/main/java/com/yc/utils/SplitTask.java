package com.yc.utils;

import java.util.ArrayList;

public class SplitTask {

    private ThreadLocal<LocalDTO> local = new ThreadLocal();

    public static void main(String[] args) {
        SplitTask splitTask = new SplitTask();
        splitTask.init();
        while (true) {
            boolean hasNext = splitTask.split();
            if (!hasNext) {
                break;
            }
        }
    }

    public void init() {
        LocalDTO localDTO = new LocalDTO(0,0);
        local.set(localDTO);
    }
    /**
     * @param addressStep
     * @param storeStep
     * @return true表示还可以分割子任务，false表示不能继续分割
     */
    public boolean split() {
        LocalDTO localDTO = local.get();
        int addressSize = 100;
        int storeSize = 10;
        int count = 0;
        int addressStep = localDTO.getAddressStep();
        for (int addressLength = addressSize; addressStep < addressLength; addressStep++) {
            int storeStep = localDTO.getStoreStep();
//            System.out.println("addressStep:" + addressStep + " storeStep:" + storeStep);
            for (int storeLength = storeSize; storeStep < storeLength; storeStep++) {
                count++;
                //如果任务大于total，则返回true
                if (count >= 99) {
                    if (++storeStep >= storeLength) {
                        localDTO.setStoreStep(0);
                        localDTO.setAddressStep(++addressStep);
                    } else {
                        localDTO.setStoreStep(storeStep);
                        localDTO.setAddressStep(addressStep);
                    }
                    System.out.println("count1:" + count);
                    return true;
                }
            }
            localDTO.setStoreStep(0);
        }
        System.out.println("count2:" + count);
        return false;
    }

}
