package com.luochen.financial.file;

import com.alibaba.excel.read.listener.ReadListener;
import com.luochen.financial.base.BaseEntity;

public interface FileReadListener<T extends BaseEntity> extends ReadListener<T> {
    int BATCH_COUNT = 500;

}
