package com.luochen.financial.file;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

/**
 * 基于mybatis-plus的文件读取并保存
 * @param <M> IService
 * @param <T> Object
 */
@Slf4j
public class FileReadListenerImpl<M extends IService<T>, T extends BaseEntity> implements FileReadListener<T> {

    private List<BaseEntity> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    protected M baseService;

    public FileReadListenerImpl(M baseService){
        this.baseService = baseService;
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        cachedDataList.add(data.correct());
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {
        baseService.saveBatch((Collection<T>) cachedDataList);
    }
}
