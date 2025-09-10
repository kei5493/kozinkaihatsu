package com.kozinkaihatsu.app.repository.common;

import java.util.List;



public interface FlowerBloomMapper {
    
    List<Integer> selectStartMonths();
    List<Integer> selectEndMonths();
}