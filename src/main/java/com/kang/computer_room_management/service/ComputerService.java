package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.Computer;
import com.kang.computer_room_management.common.domain.ComputerExample;
import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.common.domain.ComputerRoomExample;
import com.kang.computer_room_management.mapper.ComputerMapper;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerService implements IComputerService {
    Utils utils=new Utils();
    final private ComputerMapper computerMapper;
    final  private ComputerRoomMapper computerRoomMapper;
    final  private IComputerRoomService computerRoomService;
    @Autowired
    public ComputerService(ComputerMapper computerMapper, ComputerRoomMapper computerRoomMapper, IComputerRoomService computerRoomService) {
        this.computerMapper = computerMapper;
        this.computerRoomMapper = computerRoomMapper;
        this.computerRoomService = computerRoomService;
    }

    @Override
    public List<Computer> findComputers(Computer computer) {
        computerRoomService.updateRoomStatus();
        //查找所有状态等于输入状态的机子集合
        try {
            ComputerExample computerExample = new ComputerExample();
            ComputerRoomExample computerRoomExample=new ComputerRoomExample();
            computerRoomExample.createCriteria().andRstatusEqualTo(-1);
            List<ComputerRoom> computerRooms=computerRoomMapper.selectByExample(computerRoomExample);
            List<Integer> ridInStatusUp=new ArrayList<>();
            for(ComputerRoom computerRoom:computerRooms){
                ridInStatusUp.add(computerRoom.getRid());
            }
            computerExample.createCriteria().andCstatusEqualTo(computer.getCstatus()).andRidIn(ridInStatusUp);
            List<Computer> computers = computerMapper.selectByExample(computerExample);
            return computers.size()>0?computers:null;
        }catch (RuntimeException e){
            utils.printLog(e);
            return null;
        }
    }

    @Override
    public void setComputerStatusUp(Computer computer) {
        //将指定机子状态设置为可用
        computer.setCstatus(1);
        computerMapper.updateByPrimaryKeySelective(computer);
    }

    @Override
    public void setComputerStatusDown(Computer computer) {
        //将指定机子状态设置为不可用
        computer.setCstatus(0);
        computerMapper.updateByPrimaryKeySelective(computer);
    }

    @Override
    public int freeComputerInRoom(int roomId) {
        ComputerExample computerExample=new ComputerExample();
        computerExample.createCriteria().andCstatusEqualTo(1).andRidEqualTo(roomId);
        return computerMapper.countByExample(computerExample);
    }
}
