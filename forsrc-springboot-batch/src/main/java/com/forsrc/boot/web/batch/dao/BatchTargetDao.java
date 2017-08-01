package com.forsrc.boot.web.batch.dao;

import org.springframework.stereotype.Repository;

import com.forsrc.boot.batch.pojo.BatchTarget;

@Repository
public interface BatchTargetDao {

    public void create();

    void save(BatchTarget bean);
}
