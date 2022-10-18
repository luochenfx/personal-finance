package com.luochen.financial.base;

/**
 * 基础实体
 */
public abstract class BaseEntity {

    /**
     * 实现该方法确保实体的正确性
     * @return BaseEntity
     */
    public BaseEntity correct(){
        return this;
    };
}
