package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.TableTest;
import com.kang.computer_room_management.common.domain.TableTestExample;
import com.kang.computer_room_management.mapper.TableTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TableTestService implements ITableTestService{

    final TableTestMapper tableTestMapper;
    @Autowired
    public TableTestService(TableTestMapper tableTestMapper) {
        this.tableTestMapper = tableTestMapper;
    }

    @Override
    public String chaxunprocess(Model model, TableTest tableTest){
        TableTestExample tableTestExample = new TableTestExample();
        int count=tableTestMapper.countByExample(tableTestExample);
        String msg="";
        int id=tableTest.getId();
            if(tableTestMapper.selectByPrimaryKey(id)==null){
                msg="你要查询的信息不存在";
            }
            else {
                TableTest tableTest1 = tableTestMapper.selectByPrimaryKey(id);
                msg = "查询结果为：name:" + tableTest1.getName() + " info:" + tableTest1.getInfo();
            }
        List<TableTest> tableTestList=tableTestMapper.selectByExample(tableTestExample);
        model.addAttribute(tableTestList);
        model.addAttribute("num",count);
        model.addAttribute("msg",msg);
        return "chaxun";
    }
}
