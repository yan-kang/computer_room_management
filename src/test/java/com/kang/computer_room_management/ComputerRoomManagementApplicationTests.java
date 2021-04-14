package com.kang.computer_room_management;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.Computer;
import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.common.domain.TableTest;
import com.kang.computer_room_management.common.domain.TableTestExample;
import com.kang.computer_room_management.mapper.ComputerMapper;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
import com.kang.computer_room_management.mapper.TableTestMapper;
import com.kang.computer_room_management.service.IComputerRoomService;
import com.kang.computer_room_management.service.IComputerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ComputerRoomManagementApplicationTests {
    @Autowired
    TableTestMapper tableTestMapper;
    @Autowired
    ComputerRoomMapper computerRoomMapper;
    @Autowired
    ComputerMapper computerMapper;
    @Autowired
    IComputerRoomService computerRoomService;
    Utils utils=new Utils();
    @Autowired
    IComputerService computerService;
    @Test
    void contextLoads() {
//        TableTest tableTest;
//        TableTestExample example = new TableTestExample();
//        System.out.println(tableTestMapper.countByExample(example));
//        for(int i=0;i<tableTestMapper.countByExample(example);i++){
//            tableTest=tableTestMapper.selectByPrimaryKey(i+22);
//            System.out.println("id:"+tableTest.getId()+" name:"+tableTest.getName()+" info:"+tableTest.getInfo());
//        }
//        System.out.println("List遍历：");
//        List<TableTest> tableTests=tableTestMapper.selectByExample(example);
//        for(TableTest test:tableTests){
//            System.out.println("id:"+test.getId()+" name:"+test.getName()+" info:"+test.getInfo());
//        }
        ComputerRoom computerRoom=new ComputerRoom();
        computerRoom.setRstatus(1);
        List<ComputerRoom> computerRooms=computerRoomService.findRoomsAs(computerRoom);
        for(ComputerRoom computerRoom1:computerRooms){
            System.out.println("id:"+computerRoom1.getRid()+" status:"+computerRoom1.getRstatus());
        }
        List<ComputerRoom> computerRoomList=new ArrayList<>();
        for(int i=1;i<=15;i++){
            computerRoomList.add(computerRoomMapper.selectByPrimaryKey(i));
        }
        for (ComputerRoom computerRoom1:computerRoomList
             ) {
            System.out.println(computerRoom1.getRid());
        }
        //添加机房及机位
//        for(int i=1;i<21;i++){
//            ComputerRoom computerRoom=new ComputerRoom();
//            computerRoom.setRstatus(1);
//            computerRoomMapper.insert(computerRoom);
//            for(int j=1;j<31;j++){
//                Computer computer=new Computer();
//                computer.setRid(i);
//                computer.setCstatus(1);
//                computerMapper.insert(computer);
//            }
//        }
//        for(int i=50;i<600;i++){
//            Computer computer=new Computer();
//            computer.setCid(i);
//            computer.setCstatus(1);
//            System.out.println(computer.getCid()+" "+computer.getCstatus());
//            computerMapper.updateByPrimaryKeySelective(computer);
//        }

        //更新所有机房和机位状态
//        computerRoomService.updateRoomStatus();
//        computerService.updateComputerStatus();

    }
}
