package com.kozinkaihatsu.app.service.impl;

public class FlowerServiceImpl {
    
}
@Service
public classFlowerServiceImpl implementsFlowerService {

    private final SqlSessionTemplate sqlSessionTemplate;

    publicServiceImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Flowers> findAllFlower() {
        return sqlSessionTemplate.getMapper(com.kozinkaihatsu.app.repository.FlowerMapper.class).selectAll();
    }
}