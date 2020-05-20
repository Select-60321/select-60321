package com.example.demo59.service;

import com.example.demo59.entity.Admin;
import com.example.demo59.entity.*;
import com.example.demo59.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 管理员业务端，注入AdminMapper 和 除了TrainMapper之外的Mapper
 */
@Service
public class AdminService {

    @Autowired
    AdminsMapper adminMapper;

    @Autowired
    CarriagesMapper carriagesMapper;

    @Autowired
    JourneysMapper journeysMapper;

    @Autowired
    SeatTypeMapper seatTypeMapper;

    @Autowired
    StationsMapper stationsMapper;

    @Autowired
    UsersMapper usersMapper;

    /**
     * 管理员登录验证方法
     *
     * @param admin 传入管理员参数，其中密码是md5加密过的密码作为入参
     * @return 管理员对象
     */
    public Admin findExistAdmin(Admin admin) {
        if (admin.getAdminName() == null || admin.getPassword() == null) {
            return null;
        } else {
            return adminMapper.findExistAdmin(admin);
        }
    }

    /**
     * 更新基础票价
     *
     * @param seatTypeNameList 待更新的列表
     * @return
     */
    public void updateBasicPrice(Map<String, Double> seatTypeNameList) {
        seatTypeMapper.updateBasicPrice(seatTypeNameList);
    }

    /**
     * 更新车站是否active
     *
     * @param map 车站名->状态，0为正常，1为停站
     * @return -1为未更新
     */
    public int updateActiveInfo(Map<String, Integer> map) {
        if (map.size() == 0) {
            return -1;
        }
        return stationsMapper.updateActiveInfo(map);
    }

    public int updateActiveInfoSingle(String sname, Integer status) {
        if (sname == null || status == null) {
            return -1;
        }else{
            return stationsMapper.updateActiveInfoSingle(status,sname);
        }
    }

    /**
     * 插入一个站
     *
     * @param cityName       城市名
     * @param newStationName 新的站名
     * @return -1 表示没插入
     */
    public int insertOneStation(String cityName, String newStationName) {
        Cities searchCity = stationsMapper.selectCityByCityName(cityName);
        if (searchCity == null) {
            return -1;
        }
        Stations stations = new Stations();
        stations.setCityId(searchCity.getCityId());
        stations.setStationName(newStationName);
        return stationsMapper.insert(stations);
    }

    public int insertOneTrain(List<Journeys> journeysNameList, List<Carriages> carriagesList) {

//        List<Journeys> journeysList = new ArrayList<>();
//        for (int i = 1; i <= journeysNameList.size(); i++) {
//            Journeys journeys = new Journeys();
//            journeys.setTrainId(newTrainNumber);
//            journeys.setStationId(s.get(i - 1).getStationId());
//            journeys.setStationIndex(i);
//            journeys.setArriveDay(arriveDay.get(i - 1));
//            journeys.setArriveTime(arriveTime.get(i - 1));
//            journeys.setDepartDay(departDay.get(i - 1));
//            journeys.setDepartTime(departTime.get(i - 1));
//            journeys.setDistance(distance.get(i - 1));
//            journeysList.add(journeys);
//        }
        journeysMapper.insertOneNewTrainIntoJourney(journeysNameList);
//        List<Carriages> carriagesList = new ArrayList<>();
//        for (int i = 1; i <= 4; i++) {
//            Carriages carriages = new Carriages();
//            carriages.setTrainNumber(journeysNameList.get(0).getTrainId());
//            carriages.setCarriageIndex(i);
//            carriages.setSeatTypeId(i);
//            carriages.setSeatNum(40);
//            carriagesList.add(carriages);
//        }
        carriagesMapper.insertOneTrainCarriages(carriagesList);
        return 1;


    }

//    /**
//     * 找车站详细信息
//     *
//     * @param stationName 车站名
//     * @return 车站详细信息
//     */
//    public StationReferToCity findExistStationInfo(String stationName) {
//        return stationsMapper.findStationByName(stationName);
//    }


    /**
     * 向已存在的列车末尾加一站
     * @param trainNum
     * @param stationId
     * @param arriveTime
     * @param arriveDay
     * @param distance
     * @param updateDepartTime
     * @param updateDepartDay
     * @return
     */
    public int insertOneStationIntoExistTrain(String trainNum,
                                              Integer stationId,
                                              Time arriveTime,
                                              Integer arriveDay,
                                              Integer distance,
                                              Time updateDepartTime,
                                              Integer updateDepartDay) {
        List<Journeys> journeysList = journeysMapper.selectByTrainNumber(trainNum);
        int index = journeysList.size() + 1;
        Journeys journeys = new Journeys();
        journeys.setTrainId(trainNum);
        journeys.setStationIndex(index);
        journeys.setDepartDay(null);
        journeys.setDepartTime(null);
        journeys.setArriveDay(arriveDay);
        journeys.setArriveTime(arriveTime);
        journeys.setDistance(distance);
        journeys.setStationId(stationId);
        Journeys updateJourney = new Journeys();

        updateJourney.setStationId(journeysList.get(journeysList.size() - 1).getStationId());
        updateJourney.setDistance(journeysList.get(journeysList.size() - 1).getDistance());
        updateJourney.setDepartTime(updateDepartTime);
        updateJourney.setDepartDay(updateDepartDay);
        updateJourney.setJourneyId(journeysList.get(journeysList.size() - 1).getJourneyId());
        updateJourney.setTrainId(journeysList.get(journeysList.size() - 1).getTrainId());
        updateJourney.setArriveTime(journeysList.get(journeysList.size() - 1).getArriveTime());
        updateJourney.setArriveDay(journeysList.get(journeysList.size() - 1).getArriveDay());
        updateJourney.setStationIndex(journeysList.get(journeysList.size() - 1).getStationIndex());
        journeysMapper.updateByPrimaryKey(updateJourney);
        return journeysMapper.insertOneStation(journeys);
    }

    /**
     * 为某辆车删站/恢复站
     * @param trainNumber
     * @param stationIdx
     * @param status
     * @return
     */
    public int validateStation(String trainNumber, Integer stationIdx, Integer status) {
        return journeysMapper.validateStation(trainNumber, stationIdx, status);
    }

    public int cancelOneTrain(String trainNumber,Integer status) {
        return journeysMapper.cancelOneTrain(trainNumber,status);
    }
}
